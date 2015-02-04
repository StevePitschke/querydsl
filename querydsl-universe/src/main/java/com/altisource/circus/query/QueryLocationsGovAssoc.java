package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.LocationsGovAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryLocationsGovAssoc is a Querydsl query type for LocationsGovAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryLocationsGovAssoc extends com.mysema.query.sql.RelationalPathBase<LocationsGovAssocEntity> {

    private static final long serialVersionUID = 1811336432;

    public static final QueryLocationsGovAssoc locationsGovAssoc = new QueryLocationsGovAssoc("LOCATIONS.T_GOV_ASSOC");

    public final StringPath govAgency = createString("govAgency");

    public final StringPath govCheck = createString("govCheck");

    public final StringPath govContact = createString("govContact");

    public final StringPath govFax = createString("govFax");

    public final NumberPath<Double> govFee = createNumber("govFee", Double.class);

    public final StringPath govPhone = createString("govPhone");

    public final NumberPath<Double> govRate = createNumber("govRate", Double.class);

    public final StringPath locationCode = createString("locationCode");

    public final com.mysema.query.sql.PrimaryKey<LocationsGovAssocEntity> govAgencyPk = createPrimaryKey(govAgency, locationCode);

    public QueryLocationsGovAssoc(String variable) {
        super(LocationsGovAssocEntity.class, forVariable(variable), "CIRCUS", "LOCATIONS.T_GOV_ASSOC");
        addMetadata();
    }

    public QueryLocationsGovAssoc(String variable, String schema, String table) {
        super(LocationsGovAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryLocationsGovAssoc(Path<? extends LocationsGovAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "LOCATIONS.T_GOV_ASSOC");
        addMetadata();
    }

    public QueryLocationsGovAssoc(PathMetadata<?> metadata) {
        super(LocationsGovAssocEntity.class, metadata, "CIRCUS", "LOCATIONS.T_GOV_ASSOC");
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

