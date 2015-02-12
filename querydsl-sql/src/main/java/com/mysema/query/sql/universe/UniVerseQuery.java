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

import com.google.common.collect.ImmutableList;
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
import com.mysema.query.types.Constant;
import com.mysema.query.types.Expression;
import com.mysema.query.types.FactoryExpression;
import com.mysema.query.types.MapExpression;
import com.mysema.query.types.Operation;
import com.mysema.query.types.OperationImpl;
import com.mysema.query.types.Operator;
import com.mysema.query.types.Ops;
import com.mysema.query.types.Path;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.PredicateOperation;
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
		Map<Class<? extends RelationalPathBase<?>>, List<Expression<?>>> listArgs =
			new HashMap<Class<? extends RelationalPathBase<?>>, List<Expression<?>>>();
		RelationalPathBase<?> queryObj = (RelationalPathBase<?>)joins.get(0).getTarget();
		
		for (Expression<?> expr : args) {
			
			Class<? extends RelationalPathBase<?>> subQueryClass =
					isMultiValuedExpression(expr, queryObj, null);
			
			if (subQueryClass != null) {
				
				List<Expression<?>> list = listArgs.get(subQueryClass);
				
				if (list == null) {
					list = new ArrayList<Expression<?>>();
					listArgs.put(subQueryClass, list);
				}
				
				list.add(expr);
				
			} else {
				newArgs.add(expr);
			}
		}
		
		if (listArgs.isEmpty()) {
			return super.list(args);
		}
		
		int topItemsNum = newArgs.size();
		
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
		
		int topCount = 0;
		
		for (Expression<?> expr : newArgs) {
			
			if (topCount++ == topItemsNum) {
				break;
			}
			
			qlist.add(expr);
		}
		
		List<RelationalPathBase<?>> subQueryObjects = new ArrayList<RelationalPathBase<?>>();
		List<List<Expression<?>>> selectFieldLists = new ArrayList<List<Expression<?>>>();
		
		for (Class<? extends RelationalPathBase<?>> subQueryClass : listArgs.keySet()) {
			
			RelationalPathBase<?> subQueryObj;
			try {
				subQueryObj = subQueryClass.getConstructor(String.class).newInstance("SUB_QUERY");
				subQueryObjects.add(subQueryObj);
			} catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
				// XXX - can't happen.
				throw new IllegalStateException(e);
			}
			
			List<Expression<?>> selectFields = new ArrayList<Expression<?>>();
			
			for (Expression<?> multiValuedExpr : listArgs.get(subQueryClass)) {					
				selectFields.add(rewriteMultiValuedExpression(multiValuedExpr, subQueryObj));
				qlist.add(multiValuedExpr);
			}
			
			selectFieldLists.add(selectFields);
		}
		
		QTuple qtuple = new QTuple(qlist.toArray(new Expression<?>[qlist.size()]));
		
		Map<Class<? extends RelationalPathBase<?>>, List<Expression<?>>> whenClauses =
				new HashMap<Class<? extends RelationalPathBase<?>>, List<Expression<?>>>();
		
        for (BooleanOperation when : this.whenClauses) {
        	
			Class<? extends RelationalPathBase<?>> subQueryClassForWhen =
					isMultiValuedExpression(when, queryObj, null);
		
			if (subQueryClassForWhen == null) {
				throw new IllegalArgumentException("When clause not using multi-valued columns: " + when);
			}
				
			List<Expression<?>> list = whenClauses.get(subQueryClassForWhen);
			
			if (list == null) {
				list = new ArrayList<Expression<?>>();
				whenClauses.put(subQueryClassForWhen, list);
			}
			
			int field = 0;
			
			for (Class<? extends RelationalPathBase<?>> subQueryClass : listArgs.keySet()) {
				
				RelationalPathBase<?> subQueryObj = subQueryObjects.get(field++);
				
				if (subQueryClassForWhen == subQueryObj.getClass()) {
					
					Expression<?> rewrittenWhen = rewriteMultiValuedPredicate(when, subQueryObj);
					
					if (! (rewrittenWhen instanceof Predicate)) {
						throw new IllegalArgumentException("WHEN clause is not a boolean expression: " + when);
					}
					
					list.add(rewrittenWhen);
					
					break;
				}
			}
        }
        
        int rowCount = 0;
        
		for (Tuple row : results) {
			
			List<Object> values = new ArrayList<Object>();
			
			topCount = 0;
			
			for (Expression<?> expr : newArgs) {
				
				values.add(row.get(expr));
				
				if (++topCount == topItemsNum) {
					break;
				}
			}
			
			int fieldCount = 0;
			
			for (Class<? extends RelationalPathBase<?>> subQueryClass : listArgs.keySet()) {
				
				RelationalPathBase<?> subQueryObj = subQueryObjects.get(fieldCount);
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
				
				List<Expression<?>> selectFields = selectFieldLists.get(fieldCount++);
					
		        UniVerseQuery query = new UniVerseQuery(conn)
		        	.from(subQueryObj)
		        	.where(where);
		        
				List<Expression<?>> currentWhenClauses = whenClauses.get(subQueryObj.getClass());
				
				if (currentWhenClauses != null) {
					for (Expression<?> when : currentWhenClauses) {
						query.where((Predicate)when);
					}
				}
		        
		        List<Tuple> subResults = 
		            query.list(selectFields.toArray(new Expression<?>[selectFields.size()]));
		        
		        int colNo = 0;
		        
				for (Expression<?> column : selectFields) {

					List<Object> multiValue = new ArrayList<Object>();
					
					for (Tuple subRow : subResults) {
						multiValue.add(subRow.get(colNo, Object.class));
					}
					
					values.add(multiValue);
					
					colNo++;
				}
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
	
    private Class<? extends RelationalPathBase<?>> isMultiValuedExpression(Expression<?> expr,
			RelationalPathBase<?> queryObj, Class<? extends RelationalPathBase<?> > subQueryClass) {
		
		if (expr instanceof MultiValueListPath) {
			
			Class<? extends RelationalPathBase<?>> newClass = queryObj.getMetadata((Path<?>)expr).getSubQuery();
			
			if (subQueryClass == null || subQueryClass == newClass) {
				return newClass;
			}
			
			throw new IllegalArgumentException("Doesn't support expressions with multi-valued columns from different sub-tables");
		}
		
		if (expr instanceof Constant<?>) {
			return subQueryClass;
		}
		
		if (expr instanceof Path<?>) {
			
			if (subQueryClass == null) {
				return null;
			}
			
			throw new IllegalArgumentException("Mixed top-level and nested table expressions not supported");
		}
		
		if (! (expr instanceof Operation<?>)) {
			throw new IllegalStateException("Unknown state in expression evaluation: " + expr);
		}
		
		for (Expression<?> arg : ((Operation<?>)expr).getArgs()) {			
			subQueryClass = isMultiValuedExpression(arg, queryObj, subQueryClass);
		}
		
		return subQueryClass;
	}

	private Expression<?> rewriteMultiValuedPredicate(Expression<?> expr, RelationalPathBase<?> subQueryObj) {
		
		if (expr instanceof MultiValueListPath) {
			
			String name = ((Path<?>)expr).getMetadata().getName();
			
			for (Path<?> column : subQueryObj.getColumns()) {
				
				String colName = column.getMetadata().getName();
				
				if (colName.equals(name)) {
					return column;
				}
			}
			
			throw new IllegalStateException("Missing column in sub-table: " + name);
		}
		
		if (expr instanceof Constant<?>) {
			return expr;
		}
		
		if (expr instanceof Path<?>) {
			throw new IllegalArgumentException("Mixed top-level and nested table expressions not supported");
		}
		
		List<Expression<?>> args = new ArrayList<Expression<?>>();
		
		if (expr instanceof BooleanOperation) {
			
			for (Expression<?> arg : ((BooleanOperation)expr).getArgs()) {			
				args.add(rewriteMultiValuedExpression(arg, subQueryObj));
			}
			
			Predicate predicate =
					new PredicateOperation((Operator<Boolean>)((Operation<?>)expr).getOperator(),
							ImmutableList.<Expression<?>>copyOf(args));
			
			return predicate;
		}
		
		if (! (expr instanceof Operation<?>)) {
			throw new IllegalStateException("Unknown state in expression evaluation: " + expr);
		}
		
		for (Expression<?> arg : ((Operation<?>)expr).getArgs()) {			
			args.add(rewriteMultiValuedExpression(arg, subQueryObj));
		}
		
		Operation<?> operation =
				new OperationImpl<Object>(Object.class, (Operator<Object>)((Operation<?>)expr).getOperator(),
						ImmutableList.<Expression<?>>copyOf(args));
		
		return operation;
	}
    
	private Expression<?> rewriteMultiValuedExpression(Expression<?> expr,
			RelationalPathBase<?> subQueryObj) {
		
		if (expr instanceof MultiValueListPath) {
			
			String name = ((Path<?>)expr).getMetadata().getName();
			
			for (Path<?> column : subQueryObj.getColumns()) {
				
				String colName = column.getMetadata().getName();
				
				if (colName.equals(name)) {
					return column;
				}
			}
			
			throw new IllegalStateException("Missing column in sub-table: " + name);
		}
		
		if (expr instanceof Constant<?>) {
			return expr;
		}
		
		if (expr instanceof Path<?>) {
			throw new IllegalArgumentException("Mixed top-level and nested table expressions not supported");
		}
		
		if (! (expr instanceof Operation<?>)) {
			throw new IllegalStateException("Unknown state in expression evaluation: " + expr);
		}
		
		List<Expression<?>> args = new ArrayList<Expression<?>>();
		
		for (Expression<?> arg : ((Operation<?>)expr).getArgs()) {			
			args.add(rewriteMultiValuedExpression(arg, subQueryObj));
		}
		
		Operation<Object> newOp =
				new OperationImpl<Object>(Object.class, (Operator<Object>)((Operation<?>)expr).getOperator(),
						ImmutableList.<Expression<?>>copyOf(args));
		
		return newOp;
	}
    
	private <D> Expression<D> createAlias(Path<? extends Collection<D>> target, Path<D> alias) {
        return OperationImpl.create(alias.getType(), Ops.ALIAS, target, alias);
    }

    private <D> Expression<D> createAlias(MapExpression<?,D> target, Path<D> alias) {
        return OperationImpl.create(alias.getType(), Ops.ALIAS, target, alias);
    }
}
