package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ActsAnimalIdEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActsAnimalId is a Querydsl query type for ActsAnimalIdEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActsAnimalId extends com.mysema.query.sql.RelationalPathBase<ActsAnimalIdEntity> {

    private static final long serialVersionUID = -518984845;

    public static final QueryActsAnimalId actsAnimalId = new QueryActsAnimalId("ACTS.T_ANIMAL_ID");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> animalId = createNumber("animalId", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ActsAnimalIdEntity> _assocRowPk = createPrimaryKey(_assocRow, actNo);

    public QueryActsAnimalId(String variable) {
        super(ActsAnimalIdEntity.class, forVariable(variable), "CIRCUS", "ACTS.T_ANIMAL_ID");
        addMetadata();
    }

    public QueryActsAnimalId(String variable, String schema, String table) {
        super(ActsAnimalIdEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActsAnimalId(Path<? extends ActsAnimalIdEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T_ANIMAL_ID");
        addMetadata();
    }

    public QueryActsAnimalId(PathMetadata<?> metadata) {
        super(ActsAnimalIdEntity.class, metadata, "CIRCUS", "ACTS.T_ANIMAL_ID");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(animalId, ColumnMetadata.named("ANIMAL_ID").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

