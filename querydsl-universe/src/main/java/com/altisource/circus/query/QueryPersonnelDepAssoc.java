package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.PersonnelDepAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelDepAssoc is a Querydsl query type for PersonnelDepAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelDepAssoc extends com.mysema.query.sql.RelationalPathBase<PersonnelDepAssocEntity> {

    private static final long serialVersionUID = 1404358161;

    public static final QueryPersonnelDepAssoc personnelDepAssoc = new QueryPersonnelDepAssoc("PERSONNEL.T_DEP_ASSOC");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final DatePath<java.sql.Date> depDob = createDate("depDob", java.sql.Date.class);

    public final StringPath depName = createString("depName");

    public final StringPath depRelation = createString("depRelation");

    public final com.mysema.query.sql.PrimaryKey<PersonnelDepAssocEntity> badgeNoPk = createPrimaryKey(badgeNo, depName);

    public QueryPersonnelDepAssoc(String variable) {
        super(PersonnelDepAssocEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_DEP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelDepAssoc(String variable, String schema, String table) {
        super(PersonnelDepAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelDepAssoc(Path<? extends PersonnelDepAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_DEP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelDepAssoc(PathMetadata<?> metadata) {
        super(PersonnelDepAssocEntity.class, metadata, "CIRCUS", "PERSONNEL.T_DEP_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(depDob, ColumnMetadata.named("DEP_DOB").withIndex(3).ofType(Types.DATE).withSize(10));
        addMetadata(depName, ColumnMetadata.named("DEP_NAME").withIndex(2).ofType(Types.VARCHAR).withSize(254).notNull());
        addMetadata(depRelation, ColumnMetadata.named("DEP_RELATION").withIndex(4).ofType(Types.VARCHAR).withSize(254));
    }

}

