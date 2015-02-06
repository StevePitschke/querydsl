package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.EngagementsActNoImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryEngagementsActNoImpl is a Querydsl query type for EngagementsActNoImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryEngagementsActNoImpl extends com.mysema.query.sql.RelationalPathBase<EngagementsActNoImplEntity> {

    private static final long serialVersionUID = -1236252264;

    public static final QueryEngagementsActNoImpl engagementsActNo = new QueryEngagementsActNoImpl("ENGAGEMENTS.T_ACT_NO");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final DatePath<java.sql.Date> date = createDate("date", java.sql.Date.class);

    public final StringPath locationCode = createString("locationCode");

    public QueryEngagementsActNoImpl(String variable) {
        super(EngagementsActNoImplEntity.class, forVariable(variable), "CIRCUS", "ENGAGEMENTS.T_ACT_NO");
        addMetadata();
    }

    public QueryEngagementsActNoImpl(String variable, String schema, String table) {
        super(EngagementsActNoImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryEngagementsActNoImpl(Path<? extends EngagementsActNoImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ENGAGEMENTS.T_ACT_NO");
        addMetadata();
    }

    public QueryEngagementsActNoImpl(PathMetadata<?> metadata) {
        super(EngagementsActNoImplEntity.class, metadata, "CIRCUS", "ENGAGEMENTS.T_ACT_NO");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(4).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(3).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(date, ColumnMetadata.named("DATE").withIndex(2).ofType(Types.DATE).withSize(10).notNull());
        addMetadata(locationCode, ColumnMetadata.named("LOCATION_CODE").withIndex(1).ofType(Types.CHAR).withSize(7).notNull());
    }

}

