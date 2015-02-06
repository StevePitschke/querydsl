package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.RidesOperatorEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryRidesOperator is a Querydsl query type for RidesOperatorEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryRidesOperator extends com.mysema.query.sql.RelationalPathBase<RidesOperatorEntity> {

    private static final long serialVersionUID = 1738357770;

    public static final QueryRidesOperator ridesOperator = new QueryRidesOperator("RIDES.T_OPERATOR");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<RidesOperatorEntity> _assocRowPk = createPrimaryKey(_assocRow, rideId);

    public QueryRidesOperator(String variable) {
        super(RidesOperatorEntity.class, forVariable(variable), "CIRCUS", "RIDES.T_OPERATOR");
        addMetadata();
    }

    public QueryRidesOperator(String variable, String schema, String table) {
        super(RidesOperatorEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryRidesOperator(Path<? extends RidesOperatorEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "RIDES.T_OPERATOR");
        addMetadata();
    }

    public QueryRidesOperator(PathMetadata<?> metadata) {
        super(RidesOperatorEntity.class, metadata, "CIRCUS", "RIDES.T_OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

