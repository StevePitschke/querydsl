package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.PersonnelRidesAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelRidesAssocImpl is a Querydsl query type for PersonnelRidesAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelRidesAssocImpl extends com.mysema.query.sql.RelationalPathBase<PersonnelRidesAssocImplEntity> {

    private static final long serialVersionUID = 975610567;

    public static final QueryPersonnelRidesAssocImpl personnelRidesAssoc = new QueryPersonnelRidesAssocImpl("PERSONNEL.T_RIDES_ASSOC");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final NumberPath<Double> ridePay = createNumber("ridePay", Double.class);

    public QueryPersonnelRidesAssocImpl(String variable) {
        super(PersonnelRidesAssocImplEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_RIDES_ASSOC");
        addMetadata();
    }

    public QueryPersonnelRidesAssocImpl(String variable, String schema, String table) {
        super(PersonnelRidesAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelRidesAssocImpl(Path<? extends PersonnelRidesAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_RIDES_ASSOC");
        addMetadata();
    }

    public QueryPersonnelRidesAssocImpl(PathMetadata<?> metadata) {
        super(PersonnelRidesAssocImplEntity.class, metadata, "CIRCUS", "PERSONNEL.T_RIDES_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ridePay, ColumnMetadata.named("RIDE_PAY").withIndex(3).ofType(Types.DECIMAL).withSize(8).withDigits(2));
    }

}

