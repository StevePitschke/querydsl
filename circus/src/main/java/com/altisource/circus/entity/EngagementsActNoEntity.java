package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * EngagementsActNoEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EngagementsActNoEntity {

    private Integer _assocRow;

    private Integer actNo;

    private java.sql.Date date;

    private String locationCode;

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

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

}

