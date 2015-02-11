package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.PersonnelEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryPersonnelActsAssocImpl;

import com.altisource.circus.query.impl.QueryPersonnelDepAssocImpl;

import com.altisource.circus.query.impl.QueryPersonnelEquipAssocImpl;

import com.altisource.circus.query.impl.QueryPersonnelRidesAssocImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




/**
 * QueryPersonnel is a Querydsl query type for PersonnelEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnel extends com.mysema.query.sql.RelationalPathBase<PersonnelEntity> {

    private static final long serialVersionUID = 1480887595;

    public static final QueryPersonnel personnel = new QueryPersonnel("PERSONNEL.T");

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> actNo = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("actNo", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> actPay = this.<Double, NumberPath<Double>>createMultiValuedNumberList("actPay", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final StringPath adr1 = createString("adr1");

    public final StringPath adr2 = createString("adr2");

    public final StringPath adr3 = createString("adr3");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final StringPath benefits = createString("benefits");

    public final MultiValueDateListPath<DatePath<java.sql.Date>> depDob = this.<DatePath<java.sql.Date>>createMultiValuedDateList("depDob", java.sql.Date.class, DatePath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> depName = this.<StringPath>createMultiValuedStringList("depName", String.class, StringPath.class, PathInits.DIRECT2);

    public final MultiValueStringListPath<StringPath> depRelation = this.<StringPath>createMultiValuedStringList("depRelation", String.class, StringPath.class, PathInits.DIRECT2);

    public final DatePath<java.sql.Date> dob = createDate("dob", java.sql.Date.class);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> equipCode = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("equipCode", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> equipPay = this.<Double, NumberPath<Double>>createMultiValuedNumberList("equipPay", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> rideId = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("rideId", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Double, NumberPath<Double>> ridePay = this.<Double, NumberPath<Double>>createMultiValuedNumberList("ridePay", Double.class, NumberPath.class, PathInits.DIRECT2);

    public final com.mysema.query.sql.PrimaryKey<PersonnelEntity> badgeNoPk = createPrimaryKey(badgeNo);

    public QueryPersonnel(String variable) {
        super(PersonnelEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T");
        addMetadata();
    }

    public QueryPersonnel(String variable, String schema, String table) {
        super(PersonnelEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnel(Path<? extends PersonnelEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T");
        addMetadata();
    }

    public QueryPersonnel(PathMetadata<?> metadata) {
        super(PersonnelEntity.class, metadata, "CIRCUS", "PERSONNEL.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryPersonnelActsAssocImpl.class));
        addMetadata(actPay, ColumnMetadata.named("ACT_PAY").withIndex(-1).ofType(Types.DECIMAL).withSize(8).withDigits(2).withSubQuery(QueryPersonnelActsAssocImpl.class));
        addMetadata(adr1, ColumnMetadata.named("ADR1").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr2, ColumnMetadata.named("ADR2").withIndex(6).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr3, ColumnMetadata.named("ADR3").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(benefits, ColumnMetadata.named("BENEFITS").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(depDob, ColumnMetadata.named("DEP_DOB").withIndex(-1).ofType(Types.DATE).withSize(10).withSubQuery(QueryPersonnelDepAssocImpl.class));
        addMetadata(depName, ColumnMetadata.named("DEP_NAME").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryPersonnelDepAssocImpl.class));
        addMetadata(depRelation, ColumnMetadata.named("DEP_RELATION").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryPersonnelDepAssocImpl.class));
        addMetadata(dob, ColumnMetadata.named("DOB").withIndex(2).ofType(Types.DATE).withSize(10));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryPersonnelEquipAssocImpl.class));
        addMetadata(equipPay, ColumnMetadata.named("EQUIP_PAY").withIndex(-1).ofType(Types.DECIMAL).withSize(8).withDigits(2).withSubQuery(QueryPersonnelEquipAssocImpl.class));
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(4).ofType(Types.VARCHAR).withSize(254));
        addMetadata(phone, ColumnMetadata.named("PHONE").withIndex(8).ofType(Types.VARCHAR).withSize(254));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryPersonnelRidesAssocImpl.class));
        addMetadata(ridePay, ColumnMetadata.named("RIDE_PAY").withIndex(-1).ofType(Types.DECIMAL).withSize(8).withDigits(2).withSubQuery(QueryPersonnelRidesAssocImpl.class));
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(badgeNo);
        return results;
    }

}

