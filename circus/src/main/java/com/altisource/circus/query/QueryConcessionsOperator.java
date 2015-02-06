package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ConcessionsOperatorEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryConcessionsOperator is a Querydsl query type for ConcessionsOperatorEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryConcessionsOperator extends com.mysema.query.sql.RelationalPathBase<ConcessionsOperatorEntity> {

    private static final long serialVersionUID = 2112452286;

    public static final QueryConcessionsOperator concessionsOperator = new QueryConcessionsOperator("CONCESSIONS.T_OPERATOR");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> concNo = createNumber("concNo", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ConcessionsOperatorEntity> _assocRowPk = createPrimaryKey(_assocRow, concNo);

    public QueryConcessionsOperator(String variable) {
        super(ConcessionsOperatorEntity.class, forVariable(variable), "CIRCUS", "CONCESSIONS.T_OPERATOR");
        addMetadata();
    }

    public QueryConcessionsOperator(String variable, String schema, String table) {
        super(ConcessionsOperatorEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryConcessionsOperator(Path<? extends ConcessionsOperatorEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "CONCESSIONS.T_OPERATOR");
        addMetadata();
    }

    public QueryConcessionsOperator(PathMetadata<?> metadata) {
        super(ConcessionsOperatorEntity.class, metadata, "CIRCUS", "CONCESSIONS.T_OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(concNo, ColumnMetadata.named("CONC_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

