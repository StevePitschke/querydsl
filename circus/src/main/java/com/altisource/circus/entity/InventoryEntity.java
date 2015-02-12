package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * InventoryEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class InventoryEntity {

    private Double cost;

    private String description;

    private Integer itemCode;

    private String itemType;

    private List<Integer> orderQty;

    private Double price;

    private Integer qoh;

    private List<Integer> vendorCode;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public List<Integer> getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(List<Integer> orderQty) {
        this.orderQty = orderQty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQoh() {
        return qoh;
    }

    public void setQoh(Integer qoh) {
        this.qoh = qoh;
    }

    public List<Integer> getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(List<Integer> vendorCode) {
        this.vendorCode = vendorCode;
    }

}
