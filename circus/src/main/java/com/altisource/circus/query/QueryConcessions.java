package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ConcessionsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryConcessionsEquipCodeImpl;

import com.altisource.circus.query.impl.QueryConcessionsStockImpl;

import com.altisource.circus.query.impl.QueryConcessionsOperatorImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




/**
 * QueryConcessions is a Querydsl query type for ConcessionsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessions extends com.mysema.query.sql.RelationalPathBase<ConcessionsEntity> {

    private static final long serialVersionUID = 847541242;

    public static final QueryConcessions concessions = new QueryConcessions("CONCESSIONS.T");

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final StringPath description = createString("description");

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> equipCode = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("equipCode", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> itemCode = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("itemCode", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> operator = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("operator", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final MultiValueNumberListPath<Integer, NumberPath<Integer>> qty = this.<Integer, NumberPath<Integer>>createMultiValuedNumberList("qty", Integer.class, NumberPath.class, PathInits.DIRECT2);

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
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryConcessionsEquipCodeImpl.class));
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryConcessionsStockImpl.class));
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryConcessionsOperatorImpl.class));
        addMetadata(qty, ColumnMetadata.named("QTY").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryConcessionsStockImpl.class));
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(concNo);
        return results;
    }

}

