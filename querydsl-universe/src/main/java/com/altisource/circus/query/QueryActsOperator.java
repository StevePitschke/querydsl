package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.ActsOperatorEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryActsOperator is a Querydsl query type for ActsOperatorEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryActsOperator extends com.mysema.query.sql.RelationalPathBase<ActsOperatorEntity> {

    private static final long serialVersionUID = -737130976;

    public static final QueryActsOperator actsOperator = new QueryActsOperator("ACTS.T_OPERATOR");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Integer> operator = createNumber("operator", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<ActsOperatorEntity> _assocRowPk = createPrimaryKey(_assocRow, actNo);

    public QueryActsOperator(String variable) {
        super(ActsOperatorEntity.class, forVariable(variable), "CIRCUS", "ACTS.T_OPERATOR");
        addMetadata();
    }

    public QueryActsOperator(String variable, String schema, String table) {
        super(ActsOperatorEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryActsOperator(Path<? extends ActsOperatorEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "ACTS.T_OPERATOR");
        addMetadata();
    }

    public QueryActsOperator(PathMetadata<?> metadata) {
        super(ActsOperatorEntity.class, metadata, "CIRCUS", "ACTS.T_OPERATOR");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(operator, ColumnMetadata.named("OPERATOR").withIndex(2).ofType(Types.INTEGER).withSize(10));
    }

}

