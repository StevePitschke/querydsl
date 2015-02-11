package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.LocationsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryLocationsGovAssocImpl;

import com.altisource.circus.query.impl.QueryLocationsMediaAssocImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




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

    public final MultiValueStringListPath<StringPath> govAgency = this.<StringPath>createMultiValuedStringList("govAgency", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> govCheck = this.<StringPath>createMultiValuedStringList("govCheck", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> govContact = this.<StringPath>createMultiValuedStringList("govContact", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> govFax = this.<StringPath>createMultiValuedStringList("govFax", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> govFee = this.<Double, NumberPath<Double>>createMultiValuedNumberList("govFee", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> govPhone = this.<StringPath>createMultiValuedStringList("govPhone", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> govRate = this.<Double, NumberPath<Double>>createMultiValuedNumberList("govRate", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final StringPath locationCode = createString("locationCode");

    public final MultiValueStringListPath<StringPath> mediaContact = this.<StringPath>createMultiValuedStringList("mediaContact", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> mediaFax = this.<StringPath>createMultiValuedStringList("mediaFax", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> mediaName = this.<StringPath>createMultiValuedStringList("mediaName", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> mediaPhone = this.<StringPath>createMultiValuedStringList("mediaPhone", String.class, StringPath.class, PathInits.DIRECT2);

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
        addMetadata(govAgency, ColumnMetadata.named("GOV_AGENCY").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(govCheck, ColumnMetadata.named("GOV_CHECK").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(govContact, ColumnMetadata.named("GOV_CONTACT").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(govFax, ColumnMetadata.named("GOV_FAX").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(govFee, ColumnMetadata.named("GOV_FEE").withIndex(-1).ofType(Types.DECIMAL).withSize(10).withDigits(2).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(govPhone, ColumnMetadata.named("GOV_PHONE").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(govRate, ColumnMetadata.named("GOV_RATE").withIndex(-1).ofType(Types.DECIMAL).withSize(5).withDigits(3).withSubQuery(QueryLocationsGovAssocImpl.class));
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
        addMetadata(mediaContact, ColumnMetadata.named("MEDIA_CONTACT").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsMediaAssocImpl.class));
        addMetadata(mediaFax, ColumnMetadata.named("MEDIA_FAX").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsMediaAssocImpl.class));
        addMetadata(mediaName, ColumnMetadata.named("MEDIA_NAME").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsMediaAssocImpl.class));
        addMetadata(mediaPhone, ColumnMetadata.named("MEDIA_PHONE").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLocationsMediaAssocImpl.class));
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(parks, ColumnMetadata.named("PARKS").withIndex(11).ofType(Types.INTEGER).withSize(10));
        addMetadata(phone, ColumnMetadata.named("PHONE").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(seats, ColumnMetadata.named("SEATS").withIndex(10).ofType(Types.INTEGER).withSize(10));
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(locationCode);
        return results;
    }

}

