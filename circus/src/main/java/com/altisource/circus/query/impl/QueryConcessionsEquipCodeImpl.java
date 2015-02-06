package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.ConcessionsEquipCodeImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessionsEquipCodeImpl is a Querydsl query type for ConcessionsEquipCodeImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessionsEquipCodeImpl extends com.mysema.query.sql.RelationalPathBase<ConcessionsEquipCodeImplEntity> {

    private static final long serialVersionUID = 1218710119;

    public static final QueryConcessionsEquipCodeImpl concessionsEquipCode = new QueryConcessionsEquipCodeImpl("CONCESSIONS.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public QueryConcessionsEquipCodeImpl(String variable) {
        super(ConcessionsEquipCodeImplEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryConcessionsEquipCodeImpl(String variable, String schema, String table) {
        super(ConcessionsEquipCodeImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessionsEquipCodeImpl(Path<? extends ConcessionsEquipCodeImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryConcessionsEquipCodeImpl(PathMetadata<?> metadata) {
        super(ConcessionsEquipCodeImplEntity.class, metadata, "CIRCUS", "CONCESSIONS.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

