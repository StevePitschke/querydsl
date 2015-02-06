package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.LocationsGovAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryLocationsGovAssocImpl is a Querydsl query type for LocationsGovAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryLocationsGovAssocImpl extends com.mysema.query.sql.RelationalPathBase<LocationsGovAssocImplEntity> {

    private static final long serialVersionUID = -1306946414;

    public static final QueryLocationsGovAssocImpl locationsGovAssoc = new QueryLocationsGovAssocImpl("LOCATIONS.T_GOV_ASSOC");

    public final StringPath govAgency = createString("govAgency");

    public final StringPath govCheck = createString("govCheck");

    public final StringPath govContact = createString("govContact");

    public final StringPath govFax = createString("govFax");

    public final NumberPath<Double> govFee = createNumber("govFee", Double.class);

    public final StringPath govPhone = createString("govPhone");

    public final NumberPath<Double> govRate = createNumber("govRate", Double.class);

    public final StringPath locationCode = createString("locationCode");

    public QueryLocationsGovAssocImpl(String variable) {
        super(LocationsGovAssocImplEntity.class, forVariable(variable), "CIRCUS", "LOCATIONS.T_GOV_ASSOC");
        addMetadata();
    }

    public QueryLocationsGovAssocImpl(String variable, String schema, String table) {
        super(LocationsGovAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryLocationsGovAssocImpl(Path<? extends LocationsGovAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "LOCATIONS.T_GOV_ASSOC");
        addMetadata();
    }

    public QueryLocationsGovAssocImpl(PathMetadata<?> metadata) {
        super(LocationsGovAssocImplEntity.class, metadata, "CIRCUS", "LOCATIONS.T_GOV_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(govAgency, ColumnMetadata.named("GOV_AGENCY").withIndex(2).ofType(Types.VARCHAR).withSize(254).notNull());
        addMetadata(govCheck, ColumnMetadata.named("GOV_CHECK").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(govContact, ColumnMetadata.named("GOV_CONTACT").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(govFax, ColumnMetadata.named("GOV_FAX").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(govFee, ColumnMetadata.named("GOV_FEE").withIndex(6).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(govPhone, ColumnMetadata.named("GOV_PHONE").withIndex(4).ofType(Types.VARCHAR).withSize(254));
        addMetadata(govRate, ColumnMetadata.named("GOV_RATE").withIndex(8).ofType(Types.DECIMAL).withSize(5).withDigits(3));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
    }

}

