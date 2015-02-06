package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.LivestockVacAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryLivestockVacAssocImpl is a Querydsl query type for LivestockVacAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryLivestockVacAssocImpl extends com.mysema.query.sql.RelationalPathBase<LivestockVacAssocImplEntity> {

    private static final long serialVersionUID = -531472364;

    public static final QueryLivestockVacAssocImpl livestockVacAssoc = new QueryLivestockVacAssocImpl("LIVESTOCK.T_VAC_ASSOC");

    public final NumberPath<Integer> animalId = createNumber("animalId", Integer.class);

    public final StringPath vacCert = createString("vacCert");

    public final DatePath<java.sql.Date> vacDate = createDate("vacDate", java.sql.Date.class);

    public final DatePath<java.sql.Date> vacNext = createDate("vacNext", java.sql.Date.class);

    public final StringPath vacType = createString("vacType");

    public QueryLivestockVacAssocImpl(String variable) {
        super(LivestockVacAssocImplEntity.class, forVariable(variable), "CIRCUS", "LIVESTOCK.T_VAC_ASSOC");
        addMetadata();
    }

    public QueryLivestockVacAssocImpl(String variable, String schema, String table) {
        super(LivestockVacAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryLivestockVacAssocImpl(Path<? extends LivestockVacAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "LIVESTOCK.T_VAC_ASSOC");
        addMetadata();
    }

    public QueryLivestockVacAssocImpl(PathMetadata<?> metadata) {
        super(LivestockVacAssocImplEntity.class, metadata, "CIRCUS", "LIVESTOCK.T_VAC_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(animalId, ColumnMetadata.named("ANIMAL_ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(vacCert, ColumnMetadata.named("VAC_CERT").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(vacDate, ColumnMetadata.named("VAC_DATE").withIndex(3).ofType(Types.DATE).withSize(10));
        addMetadata(vacNext, ColumnMetadata.named("VAC_NEXT").withIndex(4).ofType(Types.DATE).withSize(10));
        addMetadata(vacType, ColumnMetadata.named("VAC_TYPE").withIndex(2).ofType(Types.CHAR).withSize(1).notNull());
    }

}

