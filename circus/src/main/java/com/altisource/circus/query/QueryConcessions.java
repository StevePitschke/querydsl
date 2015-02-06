package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ConcessionsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessions is a Querydsl query type for ConcessionsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessions extends com.mysema.query.sql.RelationalPathBase<ConcessionsEntity> {

    private static final long serialVersionUID = 847541242;

    public static final QueryConcessions concessions = new QueryConcessions("CONCESSIONS.T");

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final NumberPath<Integer> qty = createNumber("qty", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ConcessionsEntity> concNoPk = createPrimaryKey(concNo);

    public QueryConcessions(String variable) {
        super(ConcessionsEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T");
        addMetadata();
    }

    public QueryConcessions(String variable, String schema, String table) {
        super(ConcessionsEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessions(Path<? extends ConcessionsEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T");
        addMetadata();
    }

    public QueryConcessions(PathMetadata<?> metadata) {
        super(ConcessionsEntity.class, metadata, "CIRCUS", "CONCESSIONS.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(2).ofType(Types.VARCHAR).withSize(254));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(4).ofType(Types.INTEGER).withSize(10));
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(5).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(qty, ColumnMetadata.named("QTY").withIndex(6).ofType(Types.INTEGER).withSize(10));
    }

}

