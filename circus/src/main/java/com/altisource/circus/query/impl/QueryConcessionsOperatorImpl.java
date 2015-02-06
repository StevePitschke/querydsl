package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.ConcessionsOperatorImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessionsOperatorImpl is a Querydsl query type for ConcessionsOperatorImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessionsOperatorImpl extends com.mysema.query.sql.RelationalPathBase<ConcessionsOperatorImplEntity> {

    private static final long serialVersionUID = 1416509152;

    public static final QueryConcessionsOperatorImpl concessionsOperator = new QueryConcessionsOperatorImpl("CONCESSIONS.T_OPERATOR");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public QueryConcessionsOperatorImpl(String variable) {
        super(ConcessionsOperatorImplEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T_OPERATOR");
        addMetadata();
    }

    public QueryConcessionsOperatorImpl(String variable, String schema, String table) {
        super(ConcessionsOperatorImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessionsOperatorImpl(Path<? extends ConcessionsOperatorImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T_OPERATOR");
        addMetadata();
    }

    public QueryConcessionsOperatorImpl(PathMetadata<?> metadata) {
        super(ConcessionsOperatorImplEntity.class, metadata, "CIRCUS", "CONCESSIONS.T_OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

