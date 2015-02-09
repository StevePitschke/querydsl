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




/**
 * QueryEngagements is a Querydsl query type for EngagementsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagements extends com.mysema.query.sql.RelationalPathBase<EngagementsEntity> {

    private static final long serialVersionUID = -1218805217;

    public static final QueryEngagements engagements = new QueryEngagements("ENGAGEMENTS.T");

    public final ListPath<Integer, NumberPath<Integer>> actNo = this.<Integer, NumberPath<Integer>>createList("actNo", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Double> advance = createNumber("advance", Double.class);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final NumberPath<Integer> labor = createNumber("labor", Integer.class);

    public final StringPath locationCode = createString("locationCode");

    public final NumberPath<Double> pay = createNumber("pay", Double.class);

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
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(labor, ColumnMetadata.named("LABOR").withIndex(15).ofType(Types.INTEGER).withSize(10));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(pay, ColumnMetadata.named("PAY").withIndex(16).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(time, ColumnMetadata.named("TIME").withIndex(3).ofType(Types.TIME).withSize(8));
    }

}

