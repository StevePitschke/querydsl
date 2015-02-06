package com.altisource.circus.entity.impl;

import javax.annotation.Generated;

/**
 * EngagementsConcsAssocImplEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EngagementsConcsAssocImplEntity {

    private Integer concId;

    private Double concRevenue;

    private Integer concTickets;

    private java.sql.Date date;

    private String locationCode;

    public Integer getConcId() {
        return concId;
    }

    public void setConcId(Integer concId) {
        this.concId = concId;
    }

    public Double getConcRevenue() {
        return concRevenue;
    }

    public void setConcRevenue(Double concRevenue) {
        this.concRevenue = concRevenue;
    }

    public Integer getConcTickets() {
        return concTickets;
    }

    public void setConcTickets(Integer concTickets) {
        this.concTickets = concTickets;
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

