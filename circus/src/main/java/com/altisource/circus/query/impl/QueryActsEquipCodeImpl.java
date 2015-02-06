package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.ActsEquipCodeImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActsEquipCodeImpl is a Querydsl query type for ActsEquipCodeImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActsEquipCodeImpl extends com.mysema.query.sql.RelationalPathBase<ActsEquipCodeImplEntity> {

    private static final long serialVersionUID = 106048585;

    public static final QueryActsEquipCodeImpl actsEquipCode = new QueryActsEquipCodeImpl("ACTS.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public QueryActsEquipCodeImpl(String variable) {
        super(ActsEquipCodeImplEntity.class, forVariable(variable), "CIRCUS", "ACTS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryActsEquipCodeImpl(String variable, String schema, String table) {
        super(ActsEquipCodeImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActsEquipCodeImpl(Path<? extends ActsEquipCodeImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryActsEquipCodeImpl(PathMetadata<?> metadata) {
        super(ActsEquipCodeImplEntity.class, metadata, "CIRCUS", "ACTS.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

