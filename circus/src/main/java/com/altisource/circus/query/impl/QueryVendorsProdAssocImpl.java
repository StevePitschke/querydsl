package com.altisource.circus.query.impl;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.impl.VendorsProdAssocImplEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryVendorsProdAssocImpl is a Querydsl query type for VendorsProdAssocImplEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryVendorsProdAssocImpl extends com.mysema.query.sql.RelationalPathBase<VendorsProdAssocImplEntity> {

    private static final long serialVersionUID = -748629652;

    public static final QueryVendorsProdAssocImpl vendorsProdAssoc = new QueryVendorsProdAssocImpl("VENDORS.T_PROD_ASSOC");

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> leadTime = createNumber("leadTime", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public QueryVendorsProdAssocImpl(String variable) {
        super(VendorsProdAssocImplEntity.class, forVariable(variable), "CIRCUS", "VENDORS.T_PROD_ASSOC");
        addMetadata();
    }

    public QueryVendorsProdAssocImpl(String variable, String schema, String table) {
        super(VendorsProdAssocImplEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryVendorsProdAssocImpl(Path<? extends VendorsProdAssocImplEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "VENDORS.T_PROD_ASSOC");
        addMetadata();
    }

    public QueryVendorsProdAssocImpl(PathMetadata<?> metadata) {
        super(VendorsProdAssocImplEntity.class, metadata, "CIRCUS", "VENDORS.T_PROD_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(leadTime, ColumnMetadata.named("LEAD_TIME").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

