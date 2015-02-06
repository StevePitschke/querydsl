package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.RidesEquipCodeImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryRidesEquipCodeImpl is a Querydsl query type for RidesEquipCodeImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryRidesEquipCodeImpl extends com.mysema.query.sql.RelationalPathBase<RidesEquipCodeImplEntity> {

    private static final long serialVersionUID = -1064160485;

    public static final QueryRidesEquipCodeImpl ridesEquipCode = new QueryRidesEquipCodeImpl("RIDES.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public QueryRidesEquipCodeImpl(String variable) {
        super(RidesEquipCodeImplEntity.class, forVariable(variable), "CIRCUS", "RIDES.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryRidesEquipCodeImpl(String variable, String schema, String table) {
        super(RidesEquipCodeImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryRidesEquipCodeImpl(Path<? extends RidesEquipCodeImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "RIDES.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryRidesEquipCodeImpl(PathMetadata<?> metadata) {
        super(RidesEquipCodeImplEntity.class, metadata, "CIRCUS", "RIDES.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

