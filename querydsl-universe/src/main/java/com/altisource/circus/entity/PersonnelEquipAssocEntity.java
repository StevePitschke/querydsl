package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * PersonnelEquipAssocEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class PersonnelEquipAssocEntity {

    private Integer badgeNo;

    private Integer equipCode;

    private Double equipPay;

    public Integer getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(Integer badgeNo) {
        this.badgeNo = badgeNo;
    }

    public Integer getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(Integer equipCode) {
        this.equipCode = equipCode;
    }

    public Double getEquipPay() {
        return equipPay;
    }

    public void setEquipPay(Double equipPay) {
        this.equipPay = equipPay;
    }

}

