package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * ActsOperatorEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class ActsOperatorEntity {

    private Integer _assocRow;

    private Integer actNo;

    private Integer operator;

    public Integer get_assocRow() {
        return _assocRow;
    }

    public void set_assocRow(Integer _assocRow) {
        this._assocRow = _assocRow;
    }

    public Integer getActNo() {
        return actNo;
    }

    public void setActNo(Integer actNo) {
        this.actNo = actNo;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

}

