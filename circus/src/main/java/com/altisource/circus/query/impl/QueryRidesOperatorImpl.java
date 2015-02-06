package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.RidesOperatorImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryRidesOperatorImpl is a Querydsl query type for RidesOperatorImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryRidesOperatorImpl extends com.mysema.query.sql.RelationalPathBase<RidesOperatorImplEntity> {

    private static final long serialVersionUID = 511584172;

    public static final QueryRidesOperatorImpl ridesOperator = new QueryRidesOperatorImpl("RIDES.T_OPERATOR");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public QueryRidesOperatorImpl(String variable) {
        super(RidesOperatorImplEntity.class, forVariable(variable), "CIRCUS", "RIDES.T_OPERATOR");
        addMetadata();
    }

    public QueryRidesOperatorImpl(String variable, String schema, String table) {
        super(RidesOperatorImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryRidesOperatorImpl(Path<? extends RidesOperatorImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "RIDES.T_OPERATOR");
        addMetadata();
    }

    public QueryRidesOperatorImpl(PathMetadata<?> metadata) {
        super(RidesOperatorImplEntity.class, metadata, "CIRCUS", "RIDES.T_OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

