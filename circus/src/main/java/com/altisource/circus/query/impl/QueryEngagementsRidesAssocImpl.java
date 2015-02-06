package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.EngagementsRidesAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagementsRidesAssocImpl is a Querydsl query type for EngagementsRidesAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagementsRidesAssocImpl extends com.mysema.query.sql.RelationalPathBase<EngagementsRidesAssocImplEntity> {

    private static final long serialVersionUID = 1405389883;

    public static final QueryEngagementsRidesAssocImpl engagementsRidesAssoc = new QueryEngagementsRidesAssocImpl("ENGAGEMENTS.T_RIDES_ASSOC");

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final StringPath locationCode = createString("locationCode");

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final NumberPath<Double> rideRevenue = createNumber("rideRevenue", Double.class);

    public final NumberPath<Integer> rideTickets = createNumber("rideTickets", Integer.class);

    public QueryEngagementsRidesAssocImpl(String variable) {
        super(EngagementsRidesAssocImplEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T_RIDES_ASSOC");
        addMetadata();
    }

    public QueryEngagementsRidesAssocImpl(String variable, String schema, String table) {
        super(EngagementsRidesAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagementsRidesAssocImpl(Path<? extends EngagementsRidesAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T_RIDES_ASSOC");
        addMetadata();
    }

    public QueryEngagementsRidesAssocImpl(PathMetadata<?> metadata) {
        super(EngagementsRidesAssocImplEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T_RIDES_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(rideRevenue, ColumnMetadata.named("RIDE_REVENUE").withIndex(4).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(rideTickets, ColumnMetadata.named("RIDE_TICKETS").withIndex(5).ofType(Types.INTEGER).withSize(10));
    }

}

