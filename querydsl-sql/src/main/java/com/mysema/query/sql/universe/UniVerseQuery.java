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
import java.util.List;

import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.JoinExpression;
import com.mysema.query.JoinType;
import com.mysema.query.QueryFlag.Position;
import com.mysema.query.QueryMetadata;
import com.mysema.query.Tuple;
import com.mysema.query.sql.AbstractSQLQuery;
import com.mysema.query.sql.ColumnMetadata;
import com.mysema.query.sql.Configuration;
import com.mysema.query.sql.RelationalPathBase;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.UniVerseTemplates;
import com.mysema.query.types.Expression;
import com.mysema.query.types.MapExpression;
import com.mysema.query.types.OperationImpl;
import com.mysema.query.types.Ops;
import com.mysema.query.types.Path;
import com.mysema.query.types.QTuple;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.ComparableExpressionBase;
import com.mysema.query.types.path.ListPath;
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

    private static final String WHEN = "\nwhen ";
    
    private final Connection conn;

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

    /**
     * @return
     */
    public UniVerseQuery when(BooleanExpression whenClause) {
        return addFlag(Position.BEFORE_GROUP_BY, WHEN, whenClause);
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
		List<ListPath<?,?>> listArgs = new ArrayList<ListPath<?,?>>();
		
		for (Expression<?> expr : args) {
			if (expr instanceof ListPath<?, ?>) {
				listArgs.add((ListPath<?,?>)expr);
			} else {
				newArgs.add(expr);
			}
		}
		
		if (listArgs.isEmpty()) {
			return super.list(args);
		}
		
		RelationalPathBase<?> queryObj = (RelationalPathBase<?>)joins.get(0).getTarget();
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
		
		List<Tuple> results = super.list(newArgs.toArray(new Expression<?>[newArgs.size()]));
		List<Expression<?>> qlist = new ArrayList<Expression<?>>();
		
		for (Expression<?> expr : newArgs) {
			qlist.add(expr);
		}
		
		QTuple qtuple = null;
		int sequence = 0;
		int rowCount = 0;
		List<RelationalPathBase<?>> subQueryObjects = new ArrayList<RelationalPathBase<?>>();
		List<List<Path<?>>> selectFieldLists = new ArrayList<List<Path<?>>>();
		
		for (Tuple row : results) {
			
			List<Object> values = new ArrayList<Object>();			
			
			for (Expression<?> expr : newArgs) {
				values.add(row.get(expr));
			}
			
			int fieldCount = 0;
			
			for (ListPath<?,?> multiValuedField : listArgs) {
				
				ColumnMetadata colMeta = queryObj.getMetadata(multiValuedField);
				RelationalPathBase<?> subQueryObj;
				try {
					if (rowCount == 0) {
						subQueryObj = colMeta.getSubQuery().getConstructor(String.class).newInstance("SUB_QUERY_" + sequence++);
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
						
					selectFieldLists.add(selectFields);
				}
				
				selectFields = selectFieldLists.get(fieldCount++);
					
		        UniVerseQuery query = new UniVerseQuery(conn); 
		        List<Tuple> subResults = query.from(subQueryObj)
		            .where(where)
		            .list(selectFields.toArray(new Path<?>[selectFields.size()]));
		        
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
