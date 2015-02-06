package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.RidesEquipCodeEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryRidesEquipCode is a Querydsl query type for RidesEquipCodeEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryRidesEquipCode extends com.mysema.query.sql.RelationalPathBase<RidesEquipCodeEntity> {

    private static final long serialVersionUID = 768597629;

    public static final QueryRidesEquipCode ridesEquipCode = new QueryRidesEquipCode("RIDES.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<RidesEquipCodeEntity> _assocRowPk = createPrimaryKey(_assocRow, rideId);

    public QueryRidesEquipCode(String variable) {
        super(RidesEquipCodeEntity.class, forVariable(variable), "CIRCUS", "RIDES.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryRidesEquipCode(String variable, String schema, String table) {
        super(RidesEquipCodeEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryRidesEquipCode(Path<? extends RidesEquipCodeEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "RIDES.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryRidesEquipCode(PathMetadata<?> metadata) {
        super(RidesEquipCodeEntity.class, metadata, "CIRCUS", "RIDES.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

