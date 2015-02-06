package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.PersonnelEquipAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelEquipAssocImpl is a Querydsl query type for PersonnelEquipAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelEquipAssocImpl extends com.mysema.query.sql.RelationalPathBase<PersonnelEquipAssocImplEntity> {

    private static final long serialVersionUID = -1880903566;

    public static final QueryPersonnelEquipAssocImpl personnelEquipAssoc = new QueryPersonnelEquipAssocImpl("PERSONNEL.T_EQUIP_ASSOC");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Double> equipPay = createNumber("equipPay", Double.class);

    public QueryPersonnelEquipAssocImpl(String variable) {
        super(PersonnelEquipAssocImplEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_EQUIP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelEquipAssocImpl(String variable, String schema, String table) {
        super(PersonnelEquipAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelEquipAssocImpl(Path<? extends PersonnelEquipAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_EQUIP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelEquipAssocImpl(PathMetadata<?> metadata) {
        super(PersonnelEquipAssocImplEntity.class, metadata, "CIRCUS", "PERSONNEL.T_EQUIP_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipPay, ColumnMetadata.named("EQUIP_PAY").withIndex(3).ofType(Types.DECIMAL).withSize(8).withDigits(2));
    }

}

