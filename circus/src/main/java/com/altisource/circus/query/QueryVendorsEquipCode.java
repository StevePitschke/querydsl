package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.VendorsEquipCodeEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryVendorsEquipCode is a Querydsl query type for VendorsEquipCodeEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryVendorsEquipCode extends com.mysema.query.sql.RelationalPathBase<VendorsEquipCodeEntity> {

    private static final long serialVersionUID = 1266015437;

    public static final QueryVendorsEquipCode vendorsEquipCode = new QueryVendorsEquipCode("VENDORS.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<VendorsEquipCodeEntity> _assocRowPk = createPrimaryKey(_assocRow, vendorCode);

    public QueryVendorsEquipCode(String variable) {
        super(VendorsEquipCodeEntity.class, forVariable(variable), "CIRCUS", "VENDORS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryVendorsEquipCode(String variable, String schema, String table) {
        super(VendorsEquipCodeEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryVendorsEquipCode(Path<? extends VendorsEquipCodeEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "VENDORS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryVendorsEquipCode(PathMetadata<?> metadata) {
        super(VendorsEquipCodeEntity.class, metadata, "CIRCUS", "VENDORS.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

