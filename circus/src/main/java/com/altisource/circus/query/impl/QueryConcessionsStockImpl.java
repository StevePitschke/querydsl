package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.ConcessionsStockImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessionsStockImpl is a Querydsl query type for ConcessionsStockImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessionsStockImpl extends com.mysema.query.sql.RelationalPathBase<ConcessionsStockImplEntity> {

    private static final long serialVersionUID = -835600512;

    public static final QueryConcessionsStockImpl concessionsStock = new QueryConcessionsStockImpl("CONCESSIONS.T_STOCK");

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public QueryConcessionsStockImpl(String variable) {
        super(ConcessionsStockImplEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T_STOCK");
        addMetadata();
    }

    public QueryConcessionsStockImpl(String variable, String schema, String table) {
        super(ConcessionsStockImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessionsStockImpl(Path<? extends ConcessionsStockImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T_STOCK");
        addMetadata();
    }

    public QueryConcessionsStockImpl(PathMetadata<?> metadata) {
        super(ConcessionsStockImplEntity.class, metadata, "CIRCUS", "CONCESSIONS.T_STOCK");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(qty, ColumnMetadata.named("QTY").withIndex(3).ofType(Types.INTEGER).withSize(10));
    }

}

