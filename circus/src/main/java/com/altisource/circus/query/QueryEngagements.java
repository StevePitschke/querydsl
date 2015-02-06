package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.EngagementsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagements is a Querydsl query type for EngagementsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagements extends com.mysema.query.sql.RelationalPathBase<EngagementsEntity> {

    private static final long serialVersionUID = -1218805217;

    public static final QueryEngagements engagements = new QueryEngagements("ENGAGEMENTS.T");

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Double> advance = createNumber("advance", Double.class);

    public final NumberPath<Integer> concId = createNumber("concId", Integer.class);

    public final NumberPath<Double> concRevenue = createNumber("concRevenue", Double.class);

    public final NumberPath<Integer> concTickets = createNumber("concTickets", Integer.class);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final NumberPath<Integer> gateNumber = createNumber("gateNumber", Integer.class);

    public final NumberPath<Double> gateRevenue = createNumber("gateRevenue", Double.class);

    public final NumberPath<Integer> gateTickets = createNumber("gateTickets", Integer.class);

    public final NumberPath<Integer> labor = createNumber("labor", Integer.class);

    public final StringPath locationCode = createString("locationCode");

    public final NumberPath<Double> pay = createNumber("pay", Double.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final NumberPath<Double> rideRevenue = createNumber("rideRevenue", Double.class);

    public final NumberPath<Integer> rideTickets = createNumber("rideTickets", Integer.class);

    public final TimePath<java.sql.Time> time = createTime("time", java.sql.Time.class);

    public final com.mysema.query.sql.PrimaryKey<EngagementsEntity> datePk = createPrimaryKey(date, locationCode);

    public QueryEngagements(String variable) {
        super(EngagementsEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T");
        addMetadata();
    }

    public QueryEngagements(String variable, String schema, String table) {
        super(EngagementsEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagements(Path<? extends EngagementsEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T");
        addMetadata();
    }

    public QueryEngagements(PathMetadata<?> metadata) {
        super(EngagementsEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(8).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(advance, ColumnMetadata.named("ADVANCE").withIndex(4).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(concId, ColumnMetadata.named("CONC_ID").withIndex(12).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(concRevenue, ColumnMetadata.named("CONC_REVENUE").withIndex(13).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(concTickets, ColumnMetadata.named("CONC_TICKETS").withIndex(14).ofType(Types.INTEGER).withSize(10));
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(gateNumber, ColumnMetadata.named("GATE_NUMBER").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(gateRevenue, ColumnMetadata.named("GATE_REVENUE").withIndex(6).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(gateTickets, ColumnMetadata.named("GATE_TICKETS").withIndex(7).ofType(Types.INTEGER).withSize(10));
        addMetadata(labor, ColumnMetadata.named("LABOR").withIndex(15).ofType(Types.INTEGER).withSize(10));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(pay, ColumnMetadata.named("PAY").withIndex(16).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(9).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(rideRevenue, ColumnMetadata.named("RIDE_REVENUE").withIndex(10).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(rideTickets, ColumnMetadata.named("RIDE_TICKETS").withIndex(11).ofType(Types.INTEGER).withSize(10));
        addMetadata(time, ColumnMetadata.named("TIME").withIndex(3).ofType(Types.TIME).withSize(8));
    }

}

