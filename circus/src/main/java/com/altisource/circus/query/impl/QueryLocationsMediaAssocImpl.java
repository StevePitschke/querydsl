package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.LocationsMediaAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryLocationsMediaAssocImpl is a Querydsl query type for LocationsMediaAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryLocationsMediaAssocImpl extends com.mysema.query.sql.RelationalPathBase<LocationsMediaAssocImplEntity> {

    private static final long serialVersionUID = 798639228;

    public static final QueryLocationsMediaAssocImpl locationsMediaAssoc = new QueryLocationsMediaAssocImpl("LOCATIONS.T_MEDIA_ASSOC");

    public final StringPath locationCode = createString("locationCode");

    public final StringPath mediaContact = createString("mediaContact");

    public final StringPath mediaFax = createString("mediaFax");

    public final StringPath mediaName = createString("mediaName");

    public final StringPath mediaPhone = createString("mediaPhone");

    public QueryLocationsMediaAssocImpl(String variable) {
        super(LocationsMediaAssocImplEntity.class, forVariable(variable), "CIRCUS", "LOCATIONS.T_MEDIA_ASSOC");
        addMetadata();
    }

    public QueryLocationsMediaAssocImpl(String variable, String schema, String table) {
        super(LocationsMediaAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryLocationsMediaAssocImpl(Path<? extends LocationsMediaAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "LOCATIONS.T_MEDIA_ASSOC");
        addMetadata();
    }

    public QueryLocationsMediaAssocImpl(PathMetadata<?> metadata) {
        super(LocationsMediaAssocImplEntity.class, metadata, "CIRCUS", "LOCATIONS.T_MEDIA_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(mediaContact, ColumnMetadata.named("MEDIA_CONTACT").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(mediaFax, ColumnMetadata.named("MEDIA_FAX").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(mediaName, ColumnMetadata.named("MEDIA_NAME").withIndex(2).ofType(Types.VARCHAR).withSize(254).notNull());
        addMetadata(mediaPhone, ColumnMetadata.named("MEDIA_PHONE").withIndex(4).ofType(Types.VARCHAR).withSize(254));
    }

}

