package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * ConcessionsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class ConcessionsEntity {

    private Integer concNo;

    private String description;

    private Integer equipCode;

    private Integer itemCode;

    private Integer operator;

    private Integer qty;

    public Integer getConcNo() {
        return concNo;
    }

    public void setConcNo(Integer concNo) {
        this.concNo = concNo;
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

    public Integer getItemCode() {
        return itemCode;
    }

    public void setItemCode(Integer itemCode) {
        this.itemCode = itemCode;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

}

