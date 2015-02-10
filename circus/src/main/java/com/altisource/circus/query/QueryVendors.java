package com.altisource.circus.query;

import static com.mysema.query.types.PathMetadataFactory.*;
import com.altisource.circus.entity.VendorsEntity;


import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;

import com.altisource.circus.query.impl.QueryVendorsEquipCodeImpl;

import com.altisource.circus.query.impl.QueryVendorsProdAssocImpl;

import java.util.List;
import java.util.ArrayList;
import com.mysema.query.types.expr.ComparableExpressionBase;




/**
 * QueryVendors is a Querydsl query type for VendorsEntity
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QueryVendors extends com.mysema.query.sql.RelationalPathBase<VendorsEntity> {

    private static final long serialVersionUID = -582226698;

    public static final QueryVendors vendors = new QueryVendors("VENDORS.T");

    public final StringPath adr1 = createString("adr1");

    public final StringPath adr2 = createString("adr2");

    public final StringPath adr3 = createString("adr3");

    public final StringPath company = createString("company");

    public final StringPath contact = createString("contact");

    public final ListPath<Integer, NumberPath<Integer>> equipCode = this.<Integer, NumberPath<Integer>>createList("equipCode", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final StringPath fax = createString("fax");

    public final ListPath<Integer, NumberPath<Integer>> itemCode = this.<Integer, NumberPath<Integer>>createList("itemCode", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final ListPath<Integer, NumberPath<Integer>> leadTime = this.<Integer, NumberPath<Integer>>createList("leadTime", Integer.class, NumberPath.class, PathInits.DIRECT2);

    public final StringPath phone = createString("phone");

    public final StringPath terms = createString("terms");

    public final NumberPath<Integer> vendorCode = createNumber("vendorCode", Integer.class);

    public final com.mysema.query.sql.PrimaryKey<VendorsEntity> vendorCodePk = createPrimaryKey(vendorCode);

    public QueryVendors(String variable) {
        super(VendorsEntity.class, forVariable(variable), "CIRCUS", "VENDORS.T");
        addMetadata();
    }

    public QueryVendors(String variable, String schema, String table) {
        super(VendorsEntity.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QueryVendors(Path<? extends VendorsEntity> path) {
        super(path.getType(), path.getMetadata(), "CIRCUS", "VENDORS.T");
        addMetadata();
    }

    public QueryVendors(PathMetadata<?> metadata) {
        super(VendorsEntity.class, metadata, "CIRCUS", "VENDORS.T");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(adr1, ColumnMetadata.named("ADR1").withIndex(3).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr2, ColumnMetadata.named("ADR2").withIndex(4).ofType(Types.VARCHAR).withSize(254));
        addMetadata(adr3, ColumnMetadata.named("ADR3").withIndex(5).ofType(Types.VARCHAR).withSize(254));
        addMetadata(company, ColumnMetadata.named("COMPANY").withIndex(2).ofType(Types.VARCHAR).withSize(254));
        addMetadata(contact, ColumnMetadata.named("CONTACT").withIndex(7).ofType(Types.VARCHAR).withSize(254));
        addMetadata(equipCode, ColumnMetadata.named("EQUIP_CODE").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryVendorsEquipCodeImpl.class));
        addMetadata(fax, ColumnMetadata.named("FAX").withIndex(9).ofType(Types.VARCHAR).withSize(254));
        addMetadata(itemCode, ColumnMetadata.named("ITEM_CODE").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryVendorsProdAssocImpl.class));
        addMetadata(leadTime, ColumnMetadata.named("LEAD_TIME").withIndex(-1).ofType(Types.INTEGER).withSize(10).withSubQuery(QueryVendorsProdAssocImpl.class));
        addMetadata(phone, ColumnMetadata.named("PHONE").withIndex(8).ofType(Types.VARCHAR).withSize(254));
        addMetadata(terms, ColumnMetadata.named("TERMS").withIndex(6).ofType(Types.VARCHAR).withSize(254));
        addMetadata(vendorCode, ColumnMetadata.named("VENDOR_CODE").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

    public List<ComparableExpressionBase<?>> getKeyVariables() {
        List<ComparableExpressionBase<?>> results = new ArrayList<ComparableExpressionBase<?>>();
        results.add(vendorCode);
        return results;
    }

}

