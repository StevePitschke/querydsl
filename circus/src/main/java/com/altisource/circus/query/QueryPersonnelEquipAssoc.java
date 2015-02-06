package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.PersonnelEquipAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelEquipAssoc is a Querydsl query type for PersonnelEquipAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelEquipAssoc extends com.mysema.query.sql.RelationalPathBase<PersonnelEquipAssocEntity> {

    private static final long serialVersionUID = 1580108112;

    public static final QueryPersonnelEquipAssoc personnelEquipAssoc = new QueryPersonnelEquipAssoc("PERSONNEL.T_EQUIP_ASSOC");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Double> equipPay = createNumber("equipPay", Double.class);

    public final com.mysema.query.sql.PrimaryKey<PersonnelEquipAssocEntity> badgeNoPk = createPrimaryKey(badgeNo, equipCode);

    public QueryPersonnelEquipAssoc(String variable) {
        super(PersonnelEquipAssocEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_EQUIP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelEquipAssoc(String variable, String schema, String table) {
        super(PersonnelEquipAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelEquipAssoc(Path<? extends PersonnelEquipAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_EQUIP_ASSOC");
        addMetadata();
    }

    public QueryPersonnelEquipAssoc(PathMetadata<?> metadata) {
        super(PersonnelEquipAssocEntity.class, metadata, "CIRCUS", "PERSONNEL.T_EQUIP_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipPay, ColumnMetadata.named("EQUIP_PAY").withIndex(3).ofType(Types.DECIMAL).withSize(8).withDigits(2));
    }

}

