package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ActsEquipCodeEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActsEquipCode is a Querydsl query type for ActsEquipCodeEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActsEquipCode extends com.mysema.query.sql.RelationalPathBase<ActsEquipCodeEntity> {

    private static final long serialVersionUID = 1337857831;

    public static final QueryActsEquipCode actsEquipCode = new QueryActsEquipCode("ACTS.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ActsEquipCodeEntity> _assocRowPk = createPrimaryKey(_assocRow, actNo);

    public QueryActsEquipCode(String variable) {
        super(ActsEquipCodeEntity.class, forVariable(variable), "CIRCUS", "ACTS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryActsEquipCode(String variable, String schema, String table) {
        super(ActsEquipCodeEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActsEquipCode(Path<? extends ActsEquipCodeEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryActsEquipCode(PathMetadata<?> metadata) {
        super(ActsEquipCodeEntity.class, metadata, "CIRCUS", "ACTS.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

