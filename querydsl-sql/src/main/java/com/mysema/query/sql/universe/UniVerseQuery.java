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

	private <D> Expression<D> createAlias(Path<? extends Collection<D>> target, Path<D> alias) {
        return OperationImpl.create(alias.getType(), Ops.ALIAS, target, alias);
    }

    private <D> Expression<D> createAlias(MapExpression<?,D> target, Path<D> alias) {
        return OperationImpl.create(alias.getType(), Ops.ALIAS, target, alias);
    }
    
	@Override
    public UniVerseQuery clone(Connection conn) {
        return new UniVerseQuery(conn);
    }	
}
