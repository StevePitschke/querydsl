/*
 * © 2015 Altisource Solutions S.à r.l.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mysema.query.sql.universe;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.JoinExpression;
import com.mysema.query.JoinType;
import com.mysema.query.QueryMetadata;
import com.mysema.query.Tuple;
import com.mysema.query.sql.AbstractSQLQuery;
import com.mysema.query.sql.Configuration;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.UniVerseTemplates;
import com.mysema.query.types.Expression;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.MapExpression;
import com.mysema.query.types.OperationImpl;
import com.mysema.query.types.Ops;
import com.mysema.query.types.Path;
import com.mysema.query.types.QTuple;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.BooleanOperation;
import com.mysema.query.types.expr.ComparableExpressionBase;
import com.mysema.query.types.path.MultiValueListPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

/**
 * UniVerseQuery provides UniVerse related extensions to SQLQuery
 *
 * @author tiwe
 * @see SQLQuery
 *
 */
public class UniVerseQuery extends AbstractSQLQuery<UniVerseQuery> {

    private final Connection conn;
    private boolean recursedThruList = false;
    private List<BooleanOperation> whenClauses = new LinkedList<BooleanOperation>();

    public UniVerseQuery(Connection conn) {
        this(conn, new Configuration(new UniVerseTemplates()), new DefaultQueryMetadata());
    }

    public UniVerseQuery(Connection conn, SQLTemplates templates) {
        this(conn, new Configuration(templates), new DefaultQueryMetadata());
    }

    public UniVerseQuery(Connection conn, Configuration configuration) {
        this(conn, configuration, new DefaultQueryMetadata());
    }

    public UniVerseQuery(Connection conn, Configuration configuration, QueryMetadata metadata) {
        super(conn, configuration, metadata);
        this.conn = conn;
    }

    /**
     * Define a outer join from the Collection typed path to the alias
     *
     * @param target
     * @param alias
     * @return
     */
    public <P> UniVerseQuery outerJoin(Path<? extends Collection<P>> target, Path<P> alias) {
        getMetadata().addJoin(JoinType.OUTERJOIN, createAlias(target, alias));
        return this;
    }

    /**
     * Define a OUTERJOIN join from the Map typed path to the alias
     *
     * @param target
     * @param alias
     * @return
     */
    public <P> UniVerseQuery outerJoin(MapExpression<?,P> target, Path<P> alias) {
        getMetadata().addJoin(JoinType.OUTERJOIN, createAlias(target, alias));
        return this;
    }
    
    public final <P> UniVerseQuery outerJoin(Expression<P> target) {
    	getMetadata().addJoin(JoinType.OUTERJOIN, target);
        return this;
    }

    public UniVerseQuery when(BooleanExpression whenClause) {    	
    	this.whenClauses.add((BooleanOperation)whenClause);   	
        return this;
    }

    public UniVerseQuery when(BooleanExpression... whenClause) { 
    	for (BooleanExpression o : whenClause) {
    		this.whenClauses.add((BooleanOperation)o); 
    	}
        return this;
    }

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.ProjectableSQLQuery#list(com.mysema.query.types.Expression[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Tuple> list(Expression<?>... args) {
		
		List<JoinExpression> joins = getMetadata().getJoins();
		
		if (joins.size() > 1) {
			return super.list(args);
		}
		
		List<Expression<?>> newArgs = new ArrayList<Expression<?>>();
		Map<Class<? extends RelationalPathBase<?>>, List<Path<?>>> listArgs =
			new HashMap<Class<? extends RelationalPathBase<?>>, List<Path<?>>>();
		RelationalPathBase<?> queryObj = (RelationalPathBase<?>)joins.get(0).getTarget();
		
		for (Expression<?> expr : args) {
			
			if (expr instanceof MultiValueListPath) {
				
				Class<? extends RelationalPathBase<?>> subQuery =
					queryObj.getMetadata((Path<?>)expr).getSubQuery();
				List<Path<?>> list = listArgs.get(subQuery);
				
				if (list == null) {
					list = new ArrayList<Path<?>>();
					listArgs.put(subQuery, list);
				}
				
				list.add((Path<?>)expr);
				
			} else {
				newArgs.add(expr);
			}
		}
		
		if (listArgs.isEmpty()) {
			return super.list(args);
		}
		
		List<ComparableExpressionBase<?>> keys = queryObj.getKeyVariables();
		
		for (ComparableExpressionBase<?> key : keys) {
			
			boolean found = false;
			
			for (Expression<?> expr : newArgs) {
				if (expr.equals(key)) {
					found = true;
					break;
				}
			}
			
			if (! found) {
				newArgs.add(key);
			}
		}
		
		recursedThruList = true;
		
		List<Tuple> results = super.list(newArgs.toArray(new Expression<?>[newArgs.size()]));
		
		recursedThruList = false;
		
		List<Expression<?>> qlist = new ArrayList<Expression<?>>();
		
		for (Expression<?> expr : newArgs) {
			qlist.add(expr);
		}
		
		QTuple qtuple = null;
		int rowCount = 0;
		
		List<RelationalPathBase<?>> subQueryObjects = new ArrayList<RelationalPathBase<?>>();		
		List<List<Path<?>>> selectFieldLists = new ArrayList<List<Path<?>>>();
		
		for (Tuple row : results) {
			
			List<Object> values = new ArrayList<Object>();			
			
			for (Expression<?> expr : newArgs) {
				values.add(row.get(expr));
			}
			
			int fieldCount = 0;
			
			for (Class<? extends RelationalPathBase<?>> subQueryClass : listArgs.keySet()) {
				
				RelationalPathBase<?> subQueryObj;
				try {
					if (rowCount == 0) {
						subQueryObj = subQueryClass.getConstructor(String.class).newInstance("SUB_QUERY");
						subQueryObjects.add(subQueryObj);
					} else {
						subQueryObj = subQueryObjects.get(fieldCount);
					}
				} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
					// XXX - can't happen.
					throw new IllegalStateException(e);
				}
				
				BooleanExpression where = null;
				
				for (ComparableExpressionBase<?> key : keys) {
					
					Object value = row.get(key);
					
					for (Path<?> column : subQueryObj.getColumns()) {
						
						String colName = column.getMetadata().getName();
						
						if (colName.equals(((Path<?>)key).getMetadata().getName())) {							
							key = (ComparableExpressionBase<?>)column;							
							break;
						}
					}
					
					if (where != null) {						
						if (key instanceof NumberPath<?>) {
							where.and(((NumberPath<Integer>)key).eq((Integer)value));
						} else if (key instanceof StringPath) {
							where.and(((StringPath)key).eq((String)value));
						} else {
							throw new IllegalStateException("Unknown key type: " + key.getClass().getName());
						}
					} else {
						if (key instanceof NumberPath<?>) {
							where = ((NumberPath<Integer>)key).eq((Integer)value);
						} else if (key instanceof StringPath) {
							where = ((StringPath)key).eq((String)value);
						} else {
							throw new IllegalStateException("Unknown key type: " + key.getClass().getName());
						}
					}
				}
				
				List<Path<?>> selectFields = null;
				
				if (rowCount == 0) {
				
					selectFields = new ArrayList<Path<?>>();
					
					for (Path<?> multiValuedField : listArgs.get(subQueryClass)) {
					
						for (Path<?> column : subQueryObj.getColumns()) {
							
							String colName = column.getMetadata().getName();
							
							if (colName.equals(multiValuedField.getMetadata().getName())) {
								
								selectFields.add(column);
								
								if (rowCount == 0) {
									qlist.add(multiValuedField);
								}
								
								break;
							}
						}
					}
					
					selectFieldLists.add(selectFields);
				}
					
				selectFields = selectFieldLists.get(fieldCount++);
					
		        UniVerseQuery query = new UniVerseQuery(conn)
		        	.from(subQueryObj)
		        	.where(where);
		        
//		        for (BooleanOperation o : whenClauses) {
//		        	query = query.where(o);
//		        }
		        
		        List<Tuple> subResults = 
		            query.list(selectFields.toArray(new Path<?>[selectFields.size()]));
		        
				for (Path<?> column : selectFields) {

					List<Object> multiValue = new ArrayList<Object>();
					
					for (Tuple subRow : subResults) {
						multiValue.add(subRow.get(column));
					}
					
					values.add(multiValue);
				}
			}
			
			if (rowCount == 0) {
				qtuple = new QTuple(qlist.toArray(new Expression<?>[qlist.size()]));
			}
			
			results.set(rowCount++, qtuple.newInstance(values.toArray(new Object[values.size()])));
		}
		
		return results;
	}

	@Override
	public <RT> List<RT> list(Expression<RT> expr) {
		
		if (recursedThruList) {
			return super.list(expr);
		}
		
		List<JoinExpression> joins = getMetadata().getJoins();
		
		if (joins.size() > 1) {
			return super.list(expr);
		}
		
		RelationalPathBase<?> queryObj = (RelationalPathBase<?>)joins.get(0).getTarget();
		boolean hasMultiValuedColumns = false;
		
		for (Path<?> column : queryObj.getColumns()) {
			if (queryObj.getMetadata(column).isMultiValued()) {
				hasMultiValuedColumns = true;
				break;
			}
		}
		
		if (! hasMultiValuedColumns) {
			return super.list(expr);
		}
		
		Expression<RT> tranformedExpr = queryMixin.addProjection(expr);
        final List<RT> rv = new ArrayList<RT>();
    	List<Path<?>> columns = queryObj.getColumns();
    	Object[] row = new Object[columns.size()];
    	 		
        if (tranformedExpr instanceof FactoryExpression) {
        	
    		recursedThruList = true;
    		
        	List<Tuple> tuples = list(columns.toArray(new Path<?>[columns.size()]));
        	
    		recursedThruList = false;
    		
        	for (Tuple tuple : tuples) {
        		
        		for (int idx = 0; idx < columns.size(); idx++) {
        			row[idx] = tuple.get(columns.get(idx));
        		}
        		
        		rv.add(((FactoryExpression<RT>)tranformedExpr).newInstance(row));
        	}
        	
        } else {
        	throw new IllegalStateException("Not sure what to do with this: " + expr);
        }
        
        return rv;
	}

	@Override
    public UniVerseQuery clone(Connection conn) {
        UniVerseQuery q = new UniVerseQuery(conn, getConfiguration(), getMetadata().clone());
        q.clone(this);
        return q;
    }
    
    private <D> Expression<D> createAlias(Path<? extends Collection<D>> target, Path<D> alias) {
        return OperationImpl.create(alias.getType(), Ops.ALIAS, target, alias);
    }

    private <D> Expression<D> createAlias(MapExpression<?,D> target, Path<D> alias) {
        return OperationImpl.create(alias.getType(), Ops.ALIAS, target, alias);
    }
}
