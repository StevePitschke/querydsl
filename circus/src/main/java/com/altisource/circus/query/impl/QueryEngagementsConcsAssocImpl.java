package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.EngagementsConcsAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagementsConcsAssocImpl is a Querydsl query type for EngagementsConcsAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagementsConcsAssocImpl extends com.mysema.query.sql.RelationalPathBase<EngagementsConcsAssocImplEntity> {

    private static final long serialVersionUID = -1616486300;

    public static final QueryEngagementsConcsAssocImpl engagementsConcsAssoc = new QueryEngagementsConcsAssocImpl("ENGAGEMENTS.T_CONCS_ASSOC");

    public final NumberPath<Integer> concId = createNumber("concId", Integer.class);

    public final NumberPath<Double> concRevenue = createNumber("concRevenue", Double.class);

    public final NumberPath<Integer> concTickets = createNumber("concTickets", Integer.class);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final StringPath locationCode = createString("locationCode");

    public QueryEngagementsConcsAssocImpl(String variable) {
        super(EngagementsConcsAssocImplEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T_CONCS_ASSOC");
        addMetadata();
    }

    public QueryEngagementsConcsAssocImpl(String variable, String schema, String table) {
        super(EngagementsConcsAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagementsConcsAssocImpl(Path<? extends EngagementsConcsAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T_CONCS_ASSOC");
        addMetadata();
    }

    public QueryEngagementsConcsAssocImpl(PathMetadata<?> metadata) {
        super(EngagementsConcsAssocImplEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T_CONCS_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(concId, ColumnMetadata.named("CONC_ID").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(concRevenue, ColumnMetadata.named("CONC_REVENUE").withIndex(4).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(concTickets, ColumnMetadata.named("CONC_TICKETS").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
    }

}

