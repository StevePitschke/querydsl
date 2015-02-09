package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.LocationsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryLocations is a Querydsl query type for LocationsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryLocations extends com.mysema.query.sql.RelationalPathBase<LocationsEntity> {

    private static final long serialVersionUID = 265858025;

    public static final QueryLocations locations = new QueryLocations("LOCATIONS.T");

    public final NumberPath<Integer> acres = createNumber("acres", Integer.class);

    public final StringPath adr1 = createString("adr1");

    public final StringPath adr2 = createString("adr2");

    public final StringPath adr3 = createString("adr3");

    public final StringPath description = createString("description");

    public final StringPath fax = createString("fax");

    public final StringPath locationCode = createString("locationCode");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> parks = createNumber("parks", Integer.class);

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> seats = createNumber("seats", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<LocationsEntity> locationCodePk = createPrimaryKey(locationCode);

    public QueryLocations(String variable) {
        super(LocationsEntity.class, forVariable(variable), "CIRCUS", "LOCATIONS.T");
        addMetadata();
    }

    public QueryLocations(String variable, String schema, String table) {
        super(LocationsEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryLocations(Path<? extends LocationsEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "LOCATIONS.T");
        addMetadata();
    }

    public QueryLocations(PathMetadata<?> metadata) {
        super(LocationsEntity.class, metadata, "CIRCUS", "LOCATIONS.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(acres, ColumnMetadata.named("ACRES").withIndex(9).ofType(Types.INTEGER).withSize(10));
        addMetadata(adr1, ColumnMetadata.named("ADR1").withIndex(4).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr2, ColumnMetadata.named("ADR2").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr3, ColumnMetadata.named("ADR3").withIndex(6).ofType(Types.VARCHAR).withSize(254));
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(2).ofType(Types.VARCHAR).withSize(254));
        addMetadata(fax, ColumnMetadata.named("FAX").withIndex(8).ofType(Types.VARCHAR).withSize(254));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(parks, ColumnMetadata.named("PARKS").withIndex(11).ofType(Types.INTEGER).withSize(10));
        addMetadata(phone, ColumnMetadata.named("PHONE").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(seats, ColumnMetadata.named("SEATS").withIndex(10).ofType(Types.INTEGER).withSize(10));
    }

}

