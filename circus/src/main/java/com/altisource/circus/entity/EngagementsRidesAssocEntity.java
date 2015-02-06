package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * EngagementsRidesAssocEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EngagementsRidesAssocEntity {

    private java.sql.Date date;

    private String locationCode;

    private Integer rideId;

    private Double rideRevenue;

    private Integer rideTickets;

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

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    public Double getRideRevenue() {
        return rideRevenue;
    }

    public void setRideRevenue(Double rideRevenue) {
        this.rideRevenue = rideRevenue;
    }

    public Integer getRideTickets() {
        return rideTickets;
    }

    public void setRideTickets(Integer rideTickets) {
        this.rideTickets = rideTickets;
    }

}

