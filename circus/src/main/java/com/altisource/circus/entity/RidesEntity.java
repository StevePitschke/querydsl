package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * RidesEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class RidesEntity {

    private String description;

    private List<Integer> equipCode;

    private List<Integer> operator;

    private Integer rideId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Integer> getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(List<Integer> equipCode) {
        this.equipCode = equipCode;
    }

    public List<Integer> getOperator() {
        return operator;
    }

    public void setOperator(List<Integer> operator) {
        this.operator = operator;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

}

