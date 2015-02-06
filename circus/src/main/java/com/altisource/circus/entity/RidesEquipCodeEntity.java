package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * RidesEquipCodeEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class RidesEquipCodeEntity {

    private Integer _assocRow;

    private Integer equipCode;

    private Integer rideId;

    public Integer get_assocRow() {
        return _assocRow;
    }

    public void set_assocRow(Integer _assocRow) {
        this._assocRow = _assocRow;
    }

    public Integer getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(Integer equipCode) {
        this.equipCode = equipCode;
    }

    public Integer getRideId() {
        return rideId;
    }

    public void setRideId(Integer rideId) {
        this.rideId = rideId;
    }

}

