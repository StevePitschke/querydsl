package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.RidesEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryRides is a Querydsl query type for RidesEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryRides extends com.mysema.query.sql.RelationalPathBase<RidesEntity> {

    private static final long serialVersionUID = -1404549818;

    public static final QueryRides rides = new QueryRides("RIDES.T");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<RidesEntity> rideIdPk = createPrimaryKey(rideId);

    public QueryRides(String variable) {
        super(RidesEntity.class, forVariable(variable), "CIRCUS", "RIDES.T");
        addMetadata();
    }

    public QueryRides(String variable, String schema, String table) {
        super(RidesEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryRides(Path<? extends RidesEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "RIDES.T");
        addMetadata();
    }

    public QueryRides(PathMetadata<?> metadata) {
        super(RidesEntity.class, metadata, "CIRCUS", "RIDES.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(2).ofType(Types.VARCHAR).withSize(254));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(4).ofType(Types.INTEGER).withSize(10));
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

