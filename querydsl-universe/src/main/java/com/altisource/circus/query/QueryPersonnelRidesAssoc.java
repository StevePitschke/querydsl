package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.PersonnelRidesAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryPersonnelRidesAssoc is a Querydsl query type for PersonnelRidesAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryPersonnelRidesAssoc extends com.mysema.query.sql.RelationalPathBase<PersonnelRidesAssocEntity> {

    private static final long serialVersionUID = 1628040741;

    public static final QueryPersonnelRidesAssoc personnelRidesAssoc = new QueryPersonnelRidesAssoc("PERSONNEL.T_RIDES_ASSOC");

    public final NumberPath<Integer> badgeNo = createNumber("badgeNo", Integer.class);

    public final NumberPath<Integer> rideId = createNumber("rideId", Integer.class);

    public final NumberPath<Double> ridePay = createNumber("ridePay", Double.class);

    public final com.mysema.query.sql.PrimaryKey<PersonnelRidesAssocEntity> badgeNoPk = createPrimaryKey(badgeNo, rideId);

    public QueryPersonnelRidesAssoc(String variable) {
        super(PersonnelRidesAssocEntity.class, forVariable(variable), "CIRCUS", "PERSONNEL.T_RIDES_ASSOC");
        addMetadata();
    }

    public QueryPersonnelRidesAssoc(String variable, String schema, String table) {
        super(PersonnelRidesAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryPersonnelRidesAssoc(Path<? extends PersonnelRidesAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "PERSONNEL.T_RIDES_ASSOC");
        addMetadata();
    }

    public QueryPersonnelRidesAssoc(PathMetadata<?> metadata) {
        super(PersonnelRidesAssocEntity.class, metadata, "CIRCUS", "PERSONNEL.T_RIDES_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(badgeNo, ColumnMetadata.named("BADGE_NO").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(rideId, ColumnMetadata.named("RIDE_ID").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(ridePay, ColumnMetadata.named("RIDE_PAY").withIndex(3).ofType(Types.DECIMAL).withSize(8).withDigits(2));
    }

}

