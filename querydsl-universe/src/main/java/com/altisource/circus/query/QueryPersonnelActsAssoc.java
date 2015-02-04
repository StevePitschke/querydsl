package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.PersonnelActsAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelActsAssoc is a Querydsl query type for PersonnelActsAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelActsAssoc extends com.mysema.query.sql.RelationalPathBase<PersonnelActsAssocEntity> {

    private static final long serialVersionUID = -1812005073;

    public static final QueryPersonnelActsAssoc personnelActsAssoc = new QueryPersonnelActsAssoc("PERSONNEL.T_ACTS_ASSOC");

    public final NumberPath<Integer> actNo = createNumber("actNo", Integer.class);

    public final NumberPath<Double> actPay = createNumber("actPay", Double.class);

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<PersonnelActsAssocEntity> actNoPk = createPrimaryKey(actNo, badgeNo);

    public QueryPersonnelActsAssoc(String variable) {
        super(PersonnelActsAssocEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_ACTS_ASSOC");
        addMetadata();
    }

    public QueryPersonnelActsAssoc(String variable, String schema, String table) {
        super(PersonnelActsAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelActsAssoc(Path<? extends PersonnelActsAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_ACTS_ASSOC");
        addMetadata();
    }

    public QueryPersonnelActsAssoc(PathMetadata<?> metadata) {
        super(PersonnelActsAssocEntity.class, metadata, "CIRCUS", "PERSONNEL.T_ACTS_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(actNo, ColumnMetadata.named("ACT_NO").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(actPay, ColumnMetadata.named("ACT_PAY").withIndex(3).ofType(Types.DECIMAL).withSize(8).withDigits(2));
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

