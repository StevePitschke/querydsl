/*
 * Copyright 2011-2015, Mysema Ltd
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
package com.mysema.query.sql;

import javax.annotation.Nullable;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.infradna.tool.bridge_method_injector.WithBridgeMethods;
import com.mysema.commons.lang.CloseableIterator;
import com.mysema.query.*;
import com.mysema.query.QueryFlag.Position;
import com.mysema.query.support.Expressions;
import com.mysema.query.support.ProjectableQuery;
import com.mysema.query.support.QueryMixin;
import com.mysema.query.types.*;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.BooleanOperation;
import com.mysema.query.types.expr.ComparableExpressionBase;
import com.mysema.query.types.expr.Wildcard;
import com.mysema.query.types.path.MultiValueListPath;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;
import com.mysema.query.types.query.ListSubQuery;
import com.mysema.query.types.template.NumberTemplate;
import com.mysema.query.types.template.SimpleTemplate;

/**
 * ProjectableSQLQuery is the base type for SQL query implementations
 *
 * @param <Q> concrete subtype
 */
public abstract class ProjectableSQLQuery<Q extends ProjectableSQLQuery<Q> & Query<Q>> extends ProjectableQuery<Q> implements SQLCommonQuery<Q> {

    private static final Path<?> defaultQueryAlias = new PathImpl(Object.class, "query");

    protected final Configuration configuration;
    
    @Nullable
    protected Expression<?> union;

    protected SubQueryExpression<?> firstUnionSubQuery;

    protected boolean unionAll;

    private final Connection conn;

    protected boolean recursedThruList = false;
    
    private List<BooleanOperation> whenClauses = new LinkedList<BooleanOperation>();
    
    @SuppressWarnings("unchecked")
    public ProjectableSQLQuery(@Nullable Connection conn, QueryMixin<Q> queryMixin, Configuration configuration) {
        super(queryMixin);
        this.conn = conn;
        this.queryMixin.setSelf((Q) this);
        this.configuration = configuration;
    }

    /**
     * Add the given String literal as a join flag to the last added join with the position
     * BEFORE_TARGET
     *
     * @param flag
     * @return
     */
    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q addJoinFlag(String flag) {
        return addJoinFlag(flag, JoinFlag.Position.BEFORE_TARGET);
    }

    /**
     * Add the given String literal as a join flag to the last added join
     *
     * @param flag
     * @param position
     * @return
     */
    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    @SuppressWarnings("unchecked")
    public Q addJoinFlag(String flag, JoinFlag.Position position) {
        queryMixin.addJoinFlag(new JoinFlag(flag, position));
        return (Q)this;
    }

    /**
     * Add the given prefix and expression as a general query flag
     *
     * @param position position of the flag
     * @param prefix prefix for the flag
     * @param expr expression of the flag
     * @return
     */
    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q addFlag(Position position, String prefix, Expression<?> expr) {
        Expression<?> flag = SimpleTemplate.create(expr.getType(), prefix + "{0}", expr);
        return queryMixin.addFlag(new QueryFlag(position, flag));
    }

    /**
     * Add the given query flag
     *
     * @param flag
     * @return
     */
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q addFlag(QueryFlag flag) {
        return queryMixin.addFlag(flag);
    }

    /**
     * Add the given String literal as query flag
     *
     * @param position
     * @param flag
     * @return
     */
    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q addFlag(Position position, String flag) {
        return queryMixin.addFlag(new QueryFlag(position, flag));
    }

    /**
     * Add the given Expression as a query flag
     *
     * @param position
     * @param flag
     * @return
     */
    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q addFlag(Position position, Expression<?> flag) {
        return queryMixin.addFlag(new QueryFlag(position, flag));
    }

    @Override
    public long count() {
        Number number = uniqueResult(Wildcard.countAsInt);
        return number.longValue();
    }

    @Override
    public boolean exists() {
        return singleResult(NumberTemplate.ONE) != null;
    }

    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q from(Expression<?> arg) {
        return queryMixin.from(arg);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q from(Expression<?>... args) {
        return queryMixin.from(args);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Q from(SubQueryExpression<?> subQuery, Path<?> alias) {
        return queryMixin.from(ExpressionUtils.as((Expression) subQuery, alias));
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q fullJoin(EntityPath<?> target) {
        return queryMixin.fullJoin(target);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q fullJoin(RelationalFunctionCall<E> target, Path<E> alias) {
        return queryMixin.fullJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q fullJoin(SubQueryExpression<?> target, Path<?> alias) {
        return queryMixin.fullJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q fullJoin(ForeignKey<E> key, RelationalPath<E> entity) {
        return queryMixin.fullJoin(entity).on(key.on(entity));
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q innerJoin(EntityPath<?> target) {
        return queryMixin.innerJoin(target);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q innerJoin(RelationalFunctionCall<E> target, Path<E> alias) {
        return queryMixin.innerJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q innerJoin(SubQueryExpression<?> target, Path<?> alias) {
        return queryMixin.innerJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q innerJoin(ForeignKey<E> key, RelationalPath<E> entity) {
        return queryMixin.innerJoin(entity).on(key.on(entity));
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q join(EntityPath<?> target) {
        return queryMixin.join(target);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q join(RelationalFunctionCall<E> target, Path<E> alias) {
        return queryMixin.join(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q join(SubQueryExpression<?> target, Path<?> alias) {
        return queryMixin.join(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q join(ForeignKey<E> key, RelationalPath<E>  entity) {
        return queryMixin.join(entity).on(key.on(entity));
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q leftJoin(EntityPath<?> target) {
        return queryMixin.leftJoin(target);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q leftJoin(RelationalFunctionCall<E> target, Path<E> alias) {
        return queryMixin.leftJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q leftJoin(SubQueryExpression<?> target, Path<?> alias) {
        return queryMixin.leftJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q leftJoin(ForeignKey<E> key, RelationalPath<E>  entity) {
        return queryMixin.leftJoin(entity).on(key.on(entity));
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q rightJoin(EntityPath<?> target) {
        return queryMixin.rightJoin(target);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q rightJoin(RelationalFunctionCall<E> target, Path<E> alias) {
        return queryMixin.rightJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q rightJoin(SubQueryExpression<?> target, Path<?> alias) {
        return queryMixin.rightJoin(target, alias);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <E> Q rightJoin(ForeignKey<E> key, RelationalPath<E>  entity) {
        return queryMixin.rightJoin(entity).on(key.on(entity));
    }

    public QueryMetadata getMetadata() {
        return queryMixin.getMetadata();
    }

    @SuppressWarnings("unchecked")
    private <RT> Union<RT> innerUnion(SubQueryExpression<?>... sq) {
        queryMixin.getMetadata().setValidate(false);
        if (!queryMixin.getMetadata().getJoins().isEmpty()) {
            throw new IllegalArgumentException("Don't mix union and from");
        }
        this.union = UnionUtils.union(sq, unionAll);
        this.firstUnionSubQuery = sq[0];
        return new UnionImpl<Q ,RT>((Q)this, sq[0].getMetadata().getProjection());
    }

    @Override
    public CloseableIterator<Tuple> iterate(Expression<?>... args) {
        return iterate(queryMixin.createProjection(args));
    }

    public ProjectableSQLQuery<Q> when(BooleanExpression whenClause) {    	
    	this.whenClauses.add((BooleanOperation)whenClause);   	
        return this;
    }

    public ProjectableSQLQuery<Q> when(BooleanExpression... whenClause) { 
    	for (BooleanExpression o : whenClause) {
    		this.whenClauses.add((BooleanOperation)o); 
    	}
        return this;
    }

    @SuppressWarnings({ "unchecked", "unused" })
	@Override
    public List<Tuple> list(Expression<?>... args) {
    	
    	if (! configuration.getTemplates().usesMultiValuedColumns()) {
			return list(queryMixin.createProjection(args));
    	}
    	
		List<JoinExpression> joins = getMetadata().getJoins();
		
		if (joins.size() > 1) {
			return list(queryMixin.createProjection(args));
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
			return list(queryMixin.createProjection(args));
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
					
				Q query = clone(conn)
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
			
			@SuppressWarnings("unchecked")
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
		
		@SuppressWarnings("unchecked")
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
		
		@SuppressWarnings("unchecked")
		Operation<Object> newOp =
				new OperationImpl<Object>(Object.class, (Operator<Object>)((Operation<?>)expr).getOperator(),
						ImmutableList.<Expression<?>>copyOf(args));
		
		return newOp;
	}
    
    @Override
    public SearchResults<Tuple> listResults(Expression<?>... args) {
        return listResults(queryMixin.createProjection(args));
    }

    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q on(Predicate condition) {
        return queryMixin.on(condition);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q on(Predicate... conditions) {
        return queryMixin.on(conditions);
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    public <RT> Union<RT> union(ListSubQuery<RT>... sq) {
        return innerUnion(sq);
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <RT> Q union(Path<?> alias, ListSubQuery<RT>... sq) {
        return from(UnionUtils.union(sq, alias, false));
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    public <RT> Union<RT> union(SubQueryExpression<RT>... sq) {
        return innerUnion(sq);
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <RT> Q union(Path<?> alias, SubQueryExpression<RT>... sq) {
        return from(UnionUtils.union(sq, alias, false));
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    public <RT> Union<RT> unionAll(ListSubQuery<RT>... sq) {
        unionAll = true;
        return innerUnion(sq);
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <RT> Q unionAll(Path<?> alias, ListSubQuery<RT>... sq) {
        return from(UnionUtils.union(sq, alias, true));
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    public <RT> Union<RT> unionAll(SubQueryExpression<RT>... sq) {
        unionAll = true;
        return innerUnion(sq);
    }

    /**
     * Creates an union expression for the given subqueries
     *
     * @param <RT>
     * @param sq
     * @return
     */
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public <RT> Q unionAll(Path<?> alias, SubQueryExpression<RT>... sq) {
        return from(UnionUtils.union(sq, alias, true));
    }

    @Override
    public Tuple uniqueResult(Expression<?>... args) {
        return uniqueResult(queryMixin.createProjection(args));
    }

    @Override
    public <RT> RT uniqueResult(Expression<RT> expr) {
        if (getMetadata().getModifiers().getLimit() == null
           && !expr.toString().contains("count(")) {
            limit(2);
        }
        CloseableIterator<RT> iterator = iterate(expr);
        return uniqueResult(iterator);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q withRecursive(Path<?> alias, SubQueryExpression<?> query) {
        queryMixin.addFlag(new QueryFlag(QueryFlag.Position.WITH, SQLTemplates.RECURSIVE));
        return with(alias, query);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q withRecursive(Path<?> alias, Expression<?> query) {
        queryMixin.addFlag(new QueryFlag(QueryFlag.Position.WITH, SQLTemplates.RECURSIVE));
        return with(alias, query);
    }

    @Override
    public WithBuilder<Q> withRecursive(Path<?> alias, Path<?>... columns) {
        queryMixin.addFlag(new QueryFlag(QueryFlag.Position.WITH, SQLTemplates.RECURSIVE));
        return with(alias, columns);
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q with(Path<?> alias, SubQueryExpression<?> query) {
        Expression<?> expr = OperationImpl.create(alias.getType(), SQLOps.WITH_ALIAS, alias, query);
        return queryMixin.addFlag(new QueryFlag(QueryFlag.Position.WITH, expr));
    }

    @Override
    @WithBridgeMethods(value=AbstractSQLQuery.class, castRequired=true)
    public Q with(Path<?> alias, Expression<?> query) {
        Expression<?> expr = OperationImpl.create(alias.getType(), SQLOps.WITH_ALIAS, alias, query);
        return queryMixin.addFlag(new QueryFlag(QueryFlag.Position.WITH, expr));
    }

    @Override
    public WithBuilder<Q> with(Path<?> alias, Path<?>... columns) {
        Expression<?> columnsCombined = ExpressionUtils.list(Object.class, columns);
        Expression<?> aliasCombined = Expressions.operation(alias.getType(), SQLOps.WITH_COLUMNS, alias, columnsCombined);
        return new WithBuilder<Q>(queryMixin, aliasCombined);
    }
    
    protected void clone(Q query) {
        this.union = query.union;
        this.unionAll = query.unionAll;
        this.firstUnionSubQuery = query.firstUnionSubQuery;
    }

    @Override
    public abstract Q clone();
    
    public abstract Q clone(Connection conn);
    
    protected abstract SQLSerializer createSerializer();

    private Set<Path<?>> getRootPaths(Collection<Expression<?>> exprs) {
        Set<Path<?>> paths = Sets.newHashSet();
        for (Expression<?> e : exprs) {
            Path<?> path = e.accept(PathExtractor.DEFAULT, null);
            if (path != null && !path.getMetadata().isRoot()) {
                paths.add(path.getMetadata().getRoot());
            }
        }
        return paths;
    }

    private Collection<Expression<?>> expandProjection(Collection<Expression<?>> exprs) {
        if (exprs.size() == 1 && exprs.iterator().next() instanceof FactoryExpression) {
            return ((FactoryExpression) exprs.iterator().next()).getArgs();
        } else {
            return exprs;
        }
    }

    protected SQLSerializer serialize(boolean forCountRow) {
        SQLSerializer serializer = createSerializer();
        if (union != null) {
            if (queryMixin.getMetadata().getProjection().isEmpty() ||
                expandProjection(queryMixin.getMetadata().getProjection()).equals(
                expandProjection(firstUnionSubQuery.getMetadata().getProjection()))) {
                serializer.serializeUnion(union, queryMixin.getMetadata(), unionAll);
            } else {
                QueryMixin mixin2 = new QueryMixin(queryMixin.getMetadata().clone());
                Set<Path<?>> paths = getRootPaths(expandProjection(mixin2.getMetadata().getProjection()));
                if (paths.isEmpty()) {
                    mixin2.from(ExpressionUtils.as((Expression) union, defaultQueryAlias));
                } else if (paths.size() == 1) {
                    mixin2.from(ExpressionUtils.as((Expression) union, paths.iterator().next()));
                } else {
                    throw new IllegalStateException("Unable to create serialize union");
                }
                serializer.serialize(mixin2.getMetadata(), forCountRow);
            }
        } else {
            serializer.serialize(queryMixin.getMetadata(), forCountRow);
        }
        return serializer;
    }
    
    /**
     * Get the query as an SQL query string and bindings
     *
     * @param exprs
     * @return
     */
    public SQLBindings getSQL(Expression<?>... exprs) {
        queryMixin.addProjection(exprs);
        SQLSerializer serializer = serialize(false);
        ImmutableList.Builder<Object> args = ImmutableList.builder();
        Map<ParamExpression<?>, Object> params = getMetadata().getParams();
        for (Object o : serializer.getConstants()) {
            if (o instanceof ParamExpression) {
                if (!params.containsKey(o)) {
                    throw new ParamNotSetException((ParamExpression<?>) o);
                }
                o = queryMixin.getMetadata().getParams().get(o);
            }
            args.add(o);
        }
        return new SQLBindings(serializer.toString(), args.build());
    }
    
    public String toString() {
        SQLSerializer serializer = serialize(false);
        return serializer.toString().trim();
    }

}
