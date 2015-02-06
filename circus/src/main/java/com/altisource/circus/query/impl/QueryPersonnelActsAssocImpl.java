package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.PersonnelActsAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelActsAssocImpl is a Querydsl query type for PersonnelActsAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelActsAssocImpl extends com.mysema.query.sql.RelationalPathBase<PersonnelActsAssocImplEntity> {

    private static final long serialVersionUID = 372558797;

    public static final QueryPersonnelActsAssocImpl personnelActsAssoc = new QueryPersonnelActsAssocImpl("PERSONNEL.T_ACTS_ASSOC");

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Double> actPay = createNumber("actPay", Double.class);

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public QueryPersonnelActsAssocImpl(String variable) {
        super(PersonnelActsAssocImplEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_ACTS_ASSOC");
        addMetadata();
    }

    public QueryPersonnelActsAssocImpl(String variable, String schema, String table) {
        super(PersonnelActsAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelActsAssocImpl(Path<? extends PersonnelActsAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_ACTS_ASSOC");
        addMetadata();
    }

    public QueryPersonnelActsAssocImpl(PathMetadata<?> metadata) {
        super(PersonnelActsAssocImplEntity.class, metadata, "CIRCUS", "PERSONNEL.T_ACTS_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(actPay, ColumnMetadata.named("ACT_PAY").withIndex(3).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

