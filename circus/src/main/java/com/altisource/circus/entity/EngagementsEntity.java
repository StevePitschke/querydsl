package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * EngagementsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EngagementsEntity {

    private List<Integer> actNo;

    private Double advance;

    private java.sql.Date date;

    private Integer labor;

    private String locationCode;

    private Double pay;

    private java.sql.Time time;

    public List<Integer> getActNo() {
        return actNo;
    }

    public void setActNo(List<Integer> actNo) {
        this.actNo = actNo;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Integer getLabor() {
        return labor;
    }

    public void setLabor(Integer labor) {
        this.labor = labor;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

}

