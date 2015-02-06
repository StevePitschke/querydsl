package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.ActsOperatorImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActsOperatorImpl is a Querydsl query type for ActsOperatorImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActsOperatorImpl extends com.mysema.query.sql.RelationalPathBase<ActsOperatorImplEntity> {

    private static final long serialVersionUID = -1251782466;

    public static final QueryActsOperatorImpl actsOperator = new QueryActsOperatorImpl("ACTS.T_OPERATOR");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public QueryActsOperatorImpl(String variable) {
        super(ActsOperatorImplEntity.class, forVariable(variable), "CIRCUS", "ACTS.T_OPERATOR");
        addMetadata();
    }

    public QueryActsOperatorImpl(String variable, String schema, String table) {
        super(ActsOperatorImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActsOperatorImpl(Path<? extends ActsOperatorImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T_OPERATOR");
        addMetadata();
    }

    public QueryActsOperatorImpl(PathMetadata<?> metadata) {
        super(ActsOperatorImplEntity.class, metadata, "CIRCUS", "ACTS.T_OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

