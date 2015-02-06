package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.ActsAnimalIdImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActsAnimalIdImpl is a Querydsl query type for ActsAnimalIdImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActsAnimalIdImpl extends com.mysema.query.sql.RelationalPathBase<ActsAnimalIdImplEntity> {

    private static final long serialVersionUID = 1545278609;

    public static final QueryActsAnimalIdImpl actsAnimalId = new QueryActsAnimalIdImpl("ACTS.T_ANIMAL_ID");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> animalId = createNumber("animalId", Integer.class);

    public QueryActsAnimalIdImpl(String variable) {
        super(ActsAnimalIdImplEntity.class, forVariable(variable), "CIRCUS", "ACTS.T_ANIMAL_ID");
        addMetadata();
    }

    public QueryActsAnimalIdImpl(String variable, String schema, String table) {
        super(ActsAnimalIdImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActsAnimalIdImpl(Path<? extends ActsAnimalIdImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T_ANIMAL_ID");
        addMetadata();
    }

    public QueryActsAnimalIdImpl(PathMetadata<?> metadata) {
        super(ActsAnimalIdImplEntity.class, metadata, "CIRCUS", "ACTS.T_ANIMAL_ID");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(animalId, ColumnMetadata.named("ANIMAL_ID").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

