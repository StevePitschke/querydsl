package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * EquipmentEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EquipmentEntity {

    private Double cost;

    private String depreciation;

    private String description;

    private Integer equipCode;

    private java.sql.Date purchaseDate;

    private Integer taxLife;

    private Integer useLife;

    private Integer vendorCode;

    private String vendorRef;

    private Integer volts;

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(String depreciation) {
        this.depreciation = depreciation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(Integer equipCode) {
        this.equipCode = equipCode;
    }

    public java.sql.Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(java.sql.Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Integer getTaxLife() {
        return taxLife;
    }

    public void setTaxLife(Integer taxLife) {
        this.taxLife = taxLife;
    }

    public Integer getUseLife() {
        return useLife;
    }

    public void setUseLife(Integer useLife) {
        this.useLife = useLife;
    }

    public Integer getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(Integer vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorRef() {
        return vendorRef;
    }

    public void setVendorRef(String vendorRef) {
        this.vendorRef = vendorRef;
    }

    public Integer getVolts() {
        return volts;
    }

    public void setVolts(Integer volts) {
        this.volts = volts;
    }

}

