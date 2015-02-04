package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ConcessionsStockEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessionsStock is a Querydsl query type for ConcessionsStockEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessionsStock extends com.mysema.query.sql.RelationalPathBase<ConcessionsStockEntity> {

    private static final long serialVersionUID = 49579234;

    public static final QueryConcessionsStock concessionsStock = new QueryConcessionsStock("CONCESSIONS.T_STOCK");

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ConcessionsStockEntity> concNoPk = createPrimaryKey(concNo, itemCode);

    public QueryConcessionsStock(String variable) {
        super(ConcessionsStockEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T_STOCK");
        addMetadata();
    }

    public QueryConcessionsStock(String variable, String schema, String table) {
        super(ConcessionsStockEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessionsStock(Path<? extends ConcessionsStockEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T_STOCK");
        addMetadata();
    }

    public QueryConcessionsStock(PathMetadata<?> metadata) {
        super(ConcessionsStockEntity.class, metadata, "CIRCUS", "CONCESSIONS.T_STOCK");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(qty, ColumnMetadata.named("QTY").withIndex(3).ofType(Types.INTEGER).withSize(10));
    }

}

