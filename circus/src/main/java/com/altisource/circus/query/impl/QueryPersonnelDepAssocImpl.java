package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.PersonnelDepAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelDepAssocImpl is a Querydsl query type for PersonnelDepAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelDepAssocImpl extends com.mysema.query.sql.RelationalPathBase<PersonnelDepAssocImplEntity> {

    private static final long serialVersionUID = -1698685645;

    public static final QueryPersonnelDepAssocImpl personnelDepAssoc = new QueryPersonnelDepAssocImpl("PERSONNEL.T_DEP_ASSOC");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final DatePath<java.sql.Date> depDob = createDate("depDob", java.sql.Date.class);

    public final StringPath depName = createString("depName");

    public final StringPath depRelation = createString("depRelation");

    public QueryPersonnelDepAssocImpl(String variable) {
        super(PersonnelDepAssocImplEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_DEP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelDepAssocImpl(String variable, String schema, String table) {
        super(PersonnelDepAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelDepAssocImpl(Path<? extends PersonnelDepAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_DEP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelDepAssocImpl(PathMetadata<?> metadata) {
        super(PersonnelDepAssocImplEntity.class, metadata, "CIRCUS", "PERSONNEL.T_DEP_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(depDob, ColumnMetadata.named("DEP_DOB").withIndex(3).ofType(Types.DATE).withSize(10));
        addMetadata(depName, ColumnMetadata.named("DEP_NAME").withIndex(2).ofType(Types.VARCHAR).withSize(254).notNull());
        addMetadata(depRelation, ColumnMetadata.named("DEP_RELATION").withIndex(4).ofType(Types.VARCHAR).withSize(254));
    }

}

