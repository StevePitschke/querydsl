package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ConcessionsEquipCodeEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessionsEquipCode is a Querydsl query type for ConcessionsEquipCodeEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessionsEquipCode extends com.mysema.query.sql.RelationalPathBase<ConcessionsEquipCodeEntity> {

    private static final long serialVersionUID = -519374263;

    public static final QueryConcessionsEquipCode concessionsEquipCode = new QueryConcessionsEquipCode("CONCESSIONS.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ConcessionsEquipCodeEntity> _assocRowPk = createPrimaryKey(_assocRow, concNo);

    public QueryConcessionsEquipCode(String variable) {
        super(ConcessionsEquipCodeEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryConcessionsEquipCode(String variable, String schema, String table) {
        super(ConcessionsEquipCodeEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessionsEquipCode(Path<? extends ConcessionsEquipCodeEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryConcessionsEquipCode(PathMetadata<?> metadata) {
        super(ConcessionsEquipCodeEntity.class, metadata, "CIRCUS", "CONCESSIONS.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

