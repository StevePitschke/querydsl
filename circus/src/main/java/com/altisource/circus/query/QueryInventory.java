package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.InventoryEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryInventoryOrdersAssocImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




/**
 * QueryInventory is a Querydsl query type for InventoryEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryInventory extends com.mysema.query.sql.RelationalPathBase<InventoryEntity> {

    private static final long serialVersionUID = -778143897;

    public static final QueryInventory inventory = new QueryInventory("INVENTORY.T");

    public final NumberPath<Double> cost = createNumber("cost", Double.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final StringPath itemType = createString("itemType");

    public final ListPath<Integer, NumberPath<Integer>> orderQty = this.<Integer, NumberPath<Integer>>createList("orderQty", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final NumberPath<Integer> qoh = createNumber("qoh", Integer.class);

    public final ListPath<Integer, NumberPath<Integer>> vendorCode = this.<Integer, NumberPath<Integer>>createList("vendorCode", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final com.mysema.query.sql.PrimaryKey<InventoryEntity> itemCodePk = createPrimaryKey(itemCode);

    public QueryInventory(String variable) {
        super(InventoryEntity.class, forVariable(variable), "CIRCUS", "INVENTORY.T");
        addMetadata();
    }

    public QueryInventory(String variable, String schema, String table) {
        super(InventoryEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryInventory(Path<? extends InventoryEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "INVENTORY.T");
        addMetadata();
    }

    public QueryInventory(PathMetadata<?> metadata) {
        super(InventoryEntity.class, metadata, "CIRCUS", "INVENTORY.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(cost, ColumnMetadata.named("COST").withIndex(5).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(itemType, ColumnMetadata.named("ITEM_TYPE").withIndex(2).ofType(Types.CHAR).withSize(1));
        addMetadata(orderQty, ColumnMetadata.named("ORDER_QTY").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryInventoryOrdersAssocImpl.class));
        addMetadata(price, ColumnMetadata.named("PRICE").withIndex(6).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(qoh, ColumnMetadata.named("QOH").withIndex(4).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryInventoryOrdersAssocImpl.class));
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(itemCode);
        return results;
    }

}

