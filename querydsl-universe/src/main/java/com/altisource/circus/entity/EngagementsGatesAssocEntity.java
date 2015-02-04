package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * EngagementsGatesAssocEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EngagementsGatesAssocEntity {

    private java.sql.Date date;

    private Integer gateNumber;

    private Double gateRevenue;

    private Integer gateTickets;

    private String locationCode;

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public Integer getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Double getGateRevenue() {
        return gateRevenue;
    }

    public void setGateRevenue(Double gateRevenue) {
        this.gateRevenue = gateRevenue;
    }

    public Integer getGateTickets() {
        return gateTickets;
    }

    public void setGateTickets(Integer gateTickets) {
        this.gateTickets = gateTickets;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

}

