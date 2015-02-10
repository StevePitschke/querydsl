package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.LivestockEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryLivestockVacAssocImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




/**
 * QueryLivestock is a Querydsl query type for LivestockEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryLivestock extends com.mysema.query.sql.RelationalPathBase<LivestockEntity> {

    private static final long serialVersionUID = 1670014261;

    public static final QueryLivestock livestock = new QueryLivestock("LIVESTOCK.T");

    public final NumberPath<Integer> animalId = createNumber("animalId", Integer.class);

    public final NumberPath<Double> cost = createNumber("cost", Double.class);

    public final StringPath description = createString("description");

    public final DatePath<java.sql.Date> dob = createDate("dob", java.sql.Date.class);

    public final NumberPath<Integer> estLife = createNumber("estLife", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath origin = createString("origin");

    public final StringPath use = createString("use");

    public final ListPath<String, StringPath> vacCert = this.<String, StringPath>createList("vacCert", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<java.sql.Date, DatePath<java.sql.Date>> vacDate = this.<java.sql.Date, DatePath<java.sql.Date>>createList("vacDate", java.sql.Date.class, DatePath.class, PathInits.DIRECT2);

    public final ListPath<java.sql.Date, DatePath<java.sql.Date>> vacNext = this.<java.sql.Date, DatePath<java.sql.Date>>createList("vacNext", java.sql.Date.class, DatePath.class, PathInits.DIRECT2);

    public final ListPath<String, StringPath> vacType = this.<String, StringPath>createList("vacType", String.class, StringPath.class, PathInits.DIRECT2);

    public final com.mysema.query.sql.PrimaryKey<LivestockEntity> animalIdPk = createPrimaryKey(animalId);

    public QueryLivestock(String variable) {
        super(LivestockEntity.class, forVariable(variable), "CIRCUS", "LIVESTOCK.T");
        addMetadata();
    }

    public QueryLivestock(String variable, String schema, String table) {
        super(LivestockEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryLivestock(Path<? extends LivestockEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "LIVESTOCK.T");
        addMetadata();
    }

    public QueryLivestock(PathMetadata<?> metadata) {
        super(LivestockEntity.class, metadata, "CIRCUS", "LIVESTOCK.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(animalId, ColumnMetadata.named("ANIMAL_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(cost, ColumnMetadata.named("COST").withIndex(7).ofType(Types.DECIMAL).withSize(10).withDigits(2));
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(dob, ColumnMetadata.named("DOB").withIndex(5).ofType(Types.DATE).withSize(10));
        addMetadata(estLife, ColumnMetadata.named("EST_LIFE").withIndex(8).ofType(Types.INTEGER).withSize(10));
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(254));
        addMetadata(origin, ColumnMetadata.named("ORIGIN").withIndex(6).ofType(Types.VARCHAR).withSize(254));
        addMetadata(use, ColumnMetadata.named("USE").withIndex(4).ofType(Types.CHAR).withSize(1));
        addMetadata(vacCert, ColumnMetadata.named("VAC_CERT").withIndex(-1).ofType(Types.VARCHAR).withSize(254).withSubQuery(QueryLivestockVacAssocImpl.class));
        addMetadata(vacDate, ColumnMetadata.named("VAC_DATE").withIndex(-1).ofType(Types.DATE).withSize(10).withSubQuery(QueryLivestockVacAssocImpl.class));
        addMetadata(vacNext, ColumnMetadata.named("VAC_NEXT").withIndex(-1).ofType(Types.DATE).withSize(10).withSubQuery(QueryLivestockVacAssocImpl.class));
        addMetadata(vacType, ColumnMetadata.named("VAC_TYPE").withIndex(-1).ofType(Types.CHAR).withSize(1).withSubQuery(QueryLivestockVacAssocImpl.class));
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(animalId);
        return results;
    }

}

