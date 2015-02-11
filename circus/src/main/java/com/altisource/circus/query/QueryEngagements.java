package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.EngagementsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryEngagementsActNoImpl;

import com.altisource.circus.query.impl.QueryEngagementsConcsAssocImpl;

import com.altisource.circus.query.impl.QueryEngagementsGatesAssocImpl;

import com.altisource.circus.query.impl.QueryEngagementsRidesAssocImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




/**
 * QueryEngagements is a Querydsl query type for EngagementsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagements extends com.mysema.query.sql.RelationalPathBase<EngagementsEntity> {

    private static final long serialVersionUID = -1218805217;

    public static final QueryEngagements engagements = new QueryEngagements("ENGAGEMENTS.T");

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> actNo = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("actNo", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Double> advance = createNumber("advance", Double.class);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> concId = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("concId", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> concRevenue = this.<Double, NumberPath<Double>>createMultiValuedNumberList("concRevenue", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> concTickets = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("concTickets", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> gateNumber = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("gateNumber", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> gateRevenue = this.<Double, NumberPath<Double>>createMultiValuedNumberList("gateRevenue", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> gateTickets = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("gateTickets", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Integer> labor = createNumber("labor", Integer.class);

    public final StringPath locationCode = createString("locationCode");

    public final NumberPath<Double> pay = createNumber("pay", Double.class);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> rideId = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("rideId", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> rideRevenue = this.<Double, NumberPath<Double>>createMultiValuedNumberList("rideRevenue", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> rideTickets = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("rideTickets", Integer.class, NumberPath.class, PathInits.DIRECT2);

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
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsActNoImpl.class));
        addMetadata(advance, ColumnMetadata.named("ADVANCE").withIndex(4).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(concId, ColumnMetadata.named("CONC_ID").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsConcsAssocImpl.class));
        addMetadata(concRevenue, ColumnMetadata.named("CONC_REVENUE").withIndex(-1).ofType(Types.DECIMAL).withSize(10).withDigits(2).withSubQuery(QueryEngagementsConcsAssocImpl.class));
        addMetadata(concTickets, ColumnMetadata.named("CONC_TICKETS").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsConcsAssocImpl.class));
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(gateNumber, ColumnMetadata.named("GATE_NUMBER").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsGatesAssocImpl.class));
        addMetadata(gateRevenue, ColumnMetadata.named("GATE_REVENUE").withIndex(-1).ofType(Types.DECIMAL).withSize(10).withDigits(2).withSubQuery(QueryEngagementsGatesAssocImpl.class));
        addMetadata(gateTickets, ColumnMetadata.named("GATE_TICKETS").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsGatesAssocImpl.class));
        addMetadata(labor, ColumnMetadata.named("LABOR").withIndex(15).ofType(Types.INTEGER).withSize(10));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(pay, ColumnMetadata.named("PAY").withIndex(16).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsRidesAssocImpl.class));
        addMetadata(rideRevenue, ColumnMetadata.named("RIDE_REVENUE").withIndex(-1).ofType(Types.DECIMAL).withSize(10).withDigits(2).withSubQuery(QueryEngagementsRidesAssocImpl.class));
        addMetadata(rideTickets, ColumnMetadata.named("RIDE_TICKETS").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryEngagementsRidesAssocImpl.class));
        addMetadata(time, ColumnMetadata.named("TIME").withIndex(3).ofType(Types.TIME).withSize(8));
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(date);
        results.add(locationCode);
        return results;
    }

}

