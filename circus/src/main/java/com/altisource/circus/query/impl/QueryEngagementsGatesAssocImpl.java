package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.EngagementsGatesAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagementsGatesAssocImpl is a Querydsl query type for EngagementsGatesAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagementsGatesAssocImpl extends com.mysema.query.sql.RelationalPathBase<EngagementsGatesAssocImplEntity> {

    private static final long serialVersionUID = 1000040974;

    public static final QueryEngagementsGatesAssocImpl engagementsGatesAssoc = new QueryEngagementsGatesAssocImpl("ENGAGEMENTS.T_GATES_ASSOC");

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final NumberPath<Integer> gateNumber = createNumber("gateNumber", Integer.class);

    public final NumberPath<Double> gateRevenue = createNumber("gateRevenue", Double.class);

    public final NumberPath<Integer> gateTickets = createNumber("gateTickets", Integer.class);

    public final StringPath locationCode = createString("locationCode");

    public QueryEngagementsGatesAssocImpl(String variable) {
        super(EngagementsGatesAssocImplEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T_GATES_ASSOC");
        addMetadata();
    }

    public QueryEngagementsGatesAssocImpl(String variable, String schema, String table) {
        super(EngagementsGatesAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagementsGatesAssocImpl(Path<? extends EngagementsGatesAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T_GATES_ASSOC");
        addMetadata();
    }

    public QueryEngagementsGatesAssocImpl(PathMetadata<?> metadata) {
        super(EngagementsGatesAssocImplEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T_GATES_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(gateNumber, ColumnMetadata.named("GATE_NUMBER").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(gateRevenue, ColumnMetadata.named("GATE_REVENUE").withIndex(4).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(gateTickets, ColumnMetadata.named("GATE_TICKETS").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
    }

}

