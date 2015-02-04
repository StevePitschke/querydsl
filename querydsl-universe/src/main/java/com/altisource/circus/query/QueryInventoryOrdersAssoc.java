package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.InventoryOrdersAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryInventoryOrdersAssoc is a Querydsl query type for InventoryOrdersAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryInventoryOrdersAssoc extends com.mysema.query.sql.RelationalPathBase<InventoryOrdersAssocEntity> {

    private static final long serialVersionUID = -368943569;

    public static final QueryInventoryOrdersAssoc inventoryOrdersAssoc = new QueryInventoryOrdersAssoc("INVENTORY.T_ORDERS_ASSOC");

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> orderQty = createNumber("orderQty", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<InventoryOrdersAssocEntity> itemCodePk = createPrimaryKey(itemCode, vendorCode);

    public QueryInventoryOrdersAssoc(String variable) {
        super(InventoryOrdersAssocEntity.class, forVariable(variable), "CIRCUS", "INVENTORY.T_ORDERS_ASSOC");
        addMetadata();
    }

    public QueryInventoryOrdersAssoc(String variable, String schema, String table) {
        super(InventoryOrdersAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryInventoryOrdersAssoc(Path<? extends InventoryOrdersAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "INVENTORY.T_ORDERS_ASSOC");
        addMetadata();
    }

    public QueryInventoryOrdersAssoc(PathMetadata<?> metadata) {
        super(InventoryOrdersAssocEntity.class, metadata, "CIRCUS", "INVENTORY.T_ORDERS_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(orderQty, ColumnMetadata.named("ORDER_QTY").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

