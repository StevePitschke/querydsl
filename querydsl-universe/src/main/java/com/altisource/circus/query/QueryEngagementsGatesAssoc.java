package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.EngagementsGatesAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagementsGatesAssoc is a Querydsl query type for EngagementsGatesAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagementsGatesAssoc extends com.mysema.query.sql.RelationalPathBase<EngagementsGatesAssocEntity> {

    private static final long serialVersionUID = 737542508;

    public static final QueryEngagementsGatesAssoc engagementsGatesAssoc = new QueryEngagementsGatesAssoc("ENGAGEMENTS.T_GATES_ASSOC");

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final NumberPath<Integer> gateNumber = createNumber("gateNumber", Integer.class);

    public final NumberPath<Double> gateRevenue = createNumber("gateRevenue", Double.class);

    public final NumberPath<Integer> gateTickets = createNumber("gateTickets", Integer.class);

    public final StringPath locationCode = createString("locationCode");

    public final com.mysema.query.sql.PrimaryKey<EngagementsGatesAssocEntity> datePk = createPrimaryKey(date, gateNumber, locationCode);

    public QueryEngagementsGatesAssoc(String variable) {
        super(EngagementsGatesAssocEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T_GATES_ASSOC");
        addMetadata();
    }

    public QueryEngagementsGatesAssoc(String variable, String schema, String table) {
        super(EngagementsGatesAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagementsGatesAssoc(Path<? extends EngagementsGatesAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T_GATES_ASSOC");
        addMetadata();
    }

    public QueryEngagementsGatesAssoc(PathMetadata<?> metadata) {
        super(EngagementsGatesAssocEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T_GATES_ASSOC");
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

