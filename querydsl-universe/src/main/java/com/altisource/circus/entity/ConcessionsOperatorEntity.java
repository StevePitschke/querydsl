package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * ConcessionsOperatorEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class ConcessionsOperatorEntity {

    private Integer _assocRow;

    private Integer concNo;

    private Integer operator;

    public Integer get_assocRow() {
        return _assocRow;
    }

    public void set_assocRow(Integer _assocRow) {
        this._assocRow = _assocRow;
    }

    public Integer getConcNo() {
        return concNo;
    }

    public void setConcNo(Integer concNo) {
        this.concNo = concNo;
    }

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

}

