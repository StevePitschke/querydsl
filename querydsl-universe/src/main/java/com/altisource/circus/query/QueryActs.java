package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ActsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActs is a Querydsl query type for ActsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActs extends com.mysema.query.sql.RelationalPathBase<ActsEntity> {

    private static final long serialVersionUID = -1000749732;

    public static final QueryActs acts = new QueryActs("ACTS.T");

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> animalId = createNumber("animalId", Integer.class);

    public final StringPath description = createString("description");

    public final NumberPath<Integer> duration = createNumber("duration", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ActsEntity> actNoPk = createPrimaryKey(actNo);

    public QueryActs(String variable) {
        super(ActsEntity.class, forVariable(variable), "CIRCUS", "ACTS.T");
        addMetadata();
    }

    public QueryActs(String variable, String schema, String table) {
        super(ActsEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActs(Path<? extends ActsEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T");
        addMetadata();
    }

    public QueryActs(PathMetadata<?> metadata) {
        super(ActsEntity.class, metadata, "CIRCUS", "ACTS.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(animalId, ColumnMetadata.named("ANIMAL_ID").withIndex(5).ofType(Types.INTEGER).withSize(10));
        addMetadata(description, ColumnMetadata.named("DESCRIPTION").withIndex(2).ofType(Types.VARCHAR).withSize(254));
        addMetadata(duration, ColumnMetadata.named("DURATION").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(6).ofType(Types.INTEGER).withSize(10));
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(4).ofType(Types.INTEGER).withSize(10));
    }

}

