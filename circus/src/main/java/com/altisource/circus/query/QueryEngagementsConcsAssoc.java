package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.EngagementsConcsAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagementsConcsAssoc is a Querydsl query type for EngagementsConcsAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagementsConcsAssoc extends com.mysema.query.sql.RelationalPathBase<EngagementsConcsAssocEntity> {

    private static final long serialVersionUID = 1735758530;

    public static final QueryEngagementsConcsAssoc engagementsConcsAssoc = new QueryEngagementsConcsAssoc("ENGAGEMENTS.T_CONCS_ASSOC");

    public final NumberPath<Integer> concId = createNumber("concId", Integer.class);

    public final NumberPath<Double> concRevenue = createNumber("concRevenue", Double.class);

    public final NumberPath<Integer> concTickets = createNumber("concTickets", Integer.class);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final StringPath locationCode = createString("locationCode");

    public final com.mysema.query.sql.PrimaryKey<EngagementsConcsAssocEntity> concIdPk = createPrimaryKey(concId, date, locationCode);

    public QueryEngagementsConcsAssoc(String variable) {
        super(EngagementsConcsAssocEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T_CONCS_ASSOC");
        addMetadata();
    }

    public QueryEngagementsConcsAssoc(String variable, String schema, String table) {
        super(EngagementsConcsAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagementsConcsAssoc(Path<? extends EngagementsConcsAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T_CONCS_ASSOC");
        addMetadata();
    }

    public QueryEngagementsConcsAssoc(PathMetadata<?> metadata) {
        super(EngagementsConcsAssocEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T_CONCS_ASSOC");
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

