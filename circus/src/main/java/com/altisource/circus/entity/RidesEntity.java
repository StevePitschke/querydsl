package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * RidesEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class RidesEntity {

    private String description;

    private Integer equipCode;

    private Integer operator;

    private Integer rideId;

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

    public Integer getOperator() {
        return operator;
    }

    public void setOperator(Integer operator) {
        this.operator = operator;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

}

