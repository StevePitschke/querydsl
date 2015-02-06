package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.VendorsProdAssocEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QueryVendorsProdAssoc is a Querydsl query type for VendorsProdAssocEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryVendorsProdAssoc extends com.mysema.query.sql.RelationalPathBase<VendorsProdAssocEntity> {

    private static final long serialVersionUID = 569470158;

    public static final QueryVendorsProdAssoc vendorsProdAssoc = new QueryVendorsProdAssoc("VENDORS.T_PROD_ASSOC");

    public final NumberPath<Integer> itemCode = createNumber("itemCode", Integer.class);

    public final NumberPath<Integer> leadTime = createNumber("leadTime", Integer.class);

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<VendorsProdAssocEntity> itemCodePk = createPrimaryKey(itemCode, vendorCode);

    public QueryVendorsProdAssoc(String variable) {
        super(VendorsProdAssocEntity.class, forVariable(variable), "CIRCUS", "VENDORS.T_PROD_ASSOC");
        addMetadata();
    }

    public QueryVendorsProdAssoc(String variable, String schema, String table) {
        super(VendorsProdAssocEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryVendorsProdAssoc(Path<? extends VendorsProdAssocEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "VENDORS.T_PROD_ASSOC");
        addMetadata();
    }

    public QueryVendorsProdAssoc(PathMetadata<?> metadata) {
        super(VendorsProdAssocEntity.class, metadata, "CIRCUS", "VENDORS.T_PROD_ASSOC");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(leadTime, ColumnMetadata.named("LEAD_TIME").withIndex(3).ofType(Types.INTEGER).withSize(10));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

