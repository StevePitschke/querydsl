package com.altisource.circus.entity.impl;

import javax.annotation.Generated;

/**
 * InventoryOrdersAssocImplEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class InventoryOrdersAssocImplEntity {

    private Integer itemCode;

    private Integer orderQty;

    private Integer vendorCode;

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public Integer getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(Integer vendorCode) {
        this.vendorCode = vendorCode;
    }

}

