package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.PersonnelEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnel is a Querydsl query type for PersonnelEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnel extends com.mysema.query.sql.RelationalPathBase<PersonnelEntity> {

    private static final long serialVersionUID = 1480887595;

    public static final QueryPersonnel personnel = new QueryPersonnel("PERSONNEL.T");

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Double> actPay = createNumber("actPay", Double.class);

    public final StringPath adr1 = createString("adr1");

    public final StringPath adr2 = createString("adr2");

    public final StringPath adr3 = createString("adr3");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final StringPath benefits = createString("benefits");

    public final DatePath<java.sql.Date> depDob = createDate("depDob", java.sql.Date.class);

    public final StringPath depName = createString("depName");

    public final StringPath depRelation = createString("depRelation");

    public final DatePath<java.sql.Date> dob = createDate("dob", java.sql.Date.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Double> equipPay = createNumber("equipPay", Double.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final NumberPath<Double> ridePay = createNumber("ridePay", Double.class);

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
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(14).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(actPay, ColumnMetadata.named("ACT_PAY").withIndex(15).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(adr1, ColumnMetadata.named("ADR1").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr2, ColumnMetadata.named("ADR2").withIndex(6).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr3, ColumnMetadata.named("ADR3").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(benefits, ColumnMetadata.named("BENEFITS").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(depDob, ColumnMetadata.named("DEP_DOB").withIndex(10).ofType(Types.DATE).withSize(10));
        addMetadata(depName, ColumnMetadata.named("DEP_NAME").withIndex(9).ofType(Types.VARCHAR).withSize(254).notNull());
        addMetadata(depRelation, ColumnMetadata.named("DEP_RELATION").withIndex(11).ofType(Types.VARCHAR).withSize(254));
        addMetadata(dob, ColumnMetadata.named("DOB").withIndex(2).ofType(Types.DATE).withSize(10));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(12).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipPay, ColumnMetadata.named("EQUIP_PAY").withIndex(13).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(4).ofType(Types.VARCHAR).withSize(254));
        addMetadata(phone, ColumnMetadata.named("PHONE").withIndex(8).ofType(Types.VARCHAR).withSize(254));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(16).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ridePay, ColumnMetadata.named("RIDE_PAY").withIndex(17).ofType(Types.DECIMAL).withSize(8).withDigits(2));
    }

}

