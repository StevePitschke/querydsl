package com.altisource.circus.entity.impl;

import javax.annotation.Generated;

/**
 * PersonnelRidesAssocImplEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class PersonnelRidesAssocImplEntity {

    private Integer badgeNo;

    private Integer rideId;

    private Double ridePay;

    public Integer getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(Integer badgeNo) {
        this.badgeNo = badgeNo;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

    public Double getRidePay() {
        return ridePay;
    }

    public void setRidePay(Double ridePay) {
        this.ridePay = ridePay;
    }

}

