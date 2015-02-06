package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.InventoryOrdersAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryInventoryOrdersAssocImpl is a Querydsl query type for InventoryOrdersAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryInventoryOrdersAssocImpl extends com.mysema.query.sql.RelationalPathBase<InventoryOrdersAssocImplEntity> {

    private static final long serialVersionUID = 2111507277;

    public static final QueryInventoryOrdersAssocImpl inventoryOrdersAssoc = new QueryInventoryOrdersAssocImpl("INVENTORY.T_ORDERS_ASSOC");

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> orderQty = createNumber("orderQty", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public QueryInventoryOrdersAssocImpl(String variable) {
        super(InventoryOrdersAssocImplEntity.class, forVariable(variable), "CIRCUS", "INVENTORY.T_ORDERS_ASSOC");
        addMetadata();
    }

    public QueryInventoryOrdersAssocImpl(String variable, String schema, String table) {
        super(InventoryOrdersAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryInventoryOrdersAssocImpl(Path<? extends InventoryOrdersAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "INVENTORY.T_ORDERS_ASSOC");
        addMetadata();
    }

    public QueryInventoryOrdersAssocImpl(PathMetadata<?> metadata) {
        super(InventoryOrdersAssocImplEntity.class, metadata, "CIRCUS", "INVENTORY.T_ORDERS_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(orderQty, ColumnMetadata.named("ORDER_QTY").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

