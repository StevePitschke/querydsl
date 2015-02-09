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

    public final StringPath adr1 = createString("adr1");

    public final StringPath adr2 = createString("adr2");

    public final StringPath adr3 = createString("adr3");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final StringPath benefits = createString("benefits");

    public final DatePath<java.sql.Date> dob = createDate("dob", java.sql.Date.class);

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

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
        addMetadata(adr1, ColumnMetadata.named("ADR1").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr2, ColumnMetadata.named("ADR2").withIndex(6).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr3, ColumnMetadata.named("ADR3").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(benefits, ColumnMetadata.named("BENEFITS").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(dob, ColumnMetadata.named("DOB").withIndex(2).ofType(Types.DATE).withSize(10));
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(4).ofType(Types.VARCHAR).withSize(254));
        addMetadata(phone, ColumnMetadata.named("PHONE").withIndex(8).ofType(Types.VARCHAR).withSize(254));
    }

}

