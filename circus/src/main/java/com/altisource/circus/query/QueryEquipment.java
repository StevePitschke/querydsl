package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.EquipmentEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEquipment is a Querydsl query type for EquipmentEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEquipment extends com.mysema.query.sql.RelationalPathBase<EquipmentEntity> {

    private static final long serialVersionUID = 1227150873;

    public static final QueryEquipment equipment = new QueryEquipment("EQUIPMENT.T");

    public final NumberPath<Double> cost = createNumber("cost", Double.class);

    public final StringPath depreciation = createString("depreciation");

    public final StringPath description = createString("description");

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final DatePath<java.sql.Date> purchaseDate = createDate("purchaseDate", java.sql.Date.class);

    public final NumberPath<Integer> taxLife = createNumber("taxLife", Integer.class);

    public final NumberPath<Integer> useLife = createNumber("useLife", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public final StringPath vendorRef = createString("vendorRef");

    public final NumberPath<Integer> volts = createNumber("volts", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<EquipmentEntity> equipCodePk = createPrimaryKey(equipCode);

    public QueryEquipment(String variable) {
        super(EquipmentEntity.class, forVariable(variable), "CIRCUS", "EQUIPMENT.T");
        addMetadata();
    }

    public QueryEquipment(String variable, String schema, String table) {
        super(EquipmentEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEquipment(Path<? extends EquipmentEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "EQUIPMENT.T");
        addMetadata();
    }

    public QueryEquipment(PathMetadata<?> metadata) {
        super(EquipmentEntity.class, metadata, "CIRCUS", "EQUIPMENT.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(cost, ColumnMetadata.named("COST").withIndex(6).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(depreciation, ColumnMetadata.named("DEPRECIATION").withIndex(4).ofType(Types.CHAR).withSize(1));
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(purchaseDate, ColumnMetadata.named("PURCHASE_DATE").withIndex(10).ofType(Types.DATE).withSize(10));
        addMetadata(taxLife, ColumnMetadata.named("TAX_LIFE").withIndex(8).ofType(Types.INTEGER).withSize(10));
        addMetadata(useLife, ColumnMetadata.named("USE_LIFE").withIndex(7).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorRef, ColumnMetadata.named("VENDOR_REF").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(volts, ColumnMetadata.named("VOLTS").withIndex(9).ofType(Types.INTEGER).withSize(10));
    }

}

