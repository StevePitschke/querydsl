package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.VendorsEquipCodeImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryVendorsEquipCodeImpl is a Querydsl query type for VendorsEquipCodeImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryVendorsEquipCodeImpl extends com.mysema.query.sql.RelationalPathBase<VendorsEquipCodeImplEntity> {

    private static final long serialVersionUID = -987813397;

    public static final QueryVendorsEquipCodeImpl vendorsEquipCode = new QueryVendorsEquipCodeImpl("VENDORS.T_EQUIP_CODE");

    public final NumberPath<Integer> _assocRow = createNumber("_assocRow", Integer.class);

    public final NumberPath<Integer> equipCode = createNumber("equipCode", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public QueryVendorsEquipCodeImpl(String variable) {
        super(VendorsEquipCodeImplEntity.class, forVariable(variable), "CIRCUS", "VENDORS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryVendorsEquipCodeImpl(String variable, String schema, String table) {
        super(VendorsEquipCodeImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryVendorsEquipCodeImpl(Path<? extends VendorsEquipCodeImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "VENDORS.T_EQUIP_CODE");
        addMetadata();
    }

    public QueryVendorsEquipCodeImpl(PathMetadata<?> metadata) {
        super(VendorsEquipCodeImplEntity.class, metadata, "CIRCUS", "VENDORS.T_EQUIP_CODE");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(_assocRow, ColumnMetadata.named("@ASSOC_ROW").withIndex(3).ofType(Types.NUMERIC).withSize(9).notNull());
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

