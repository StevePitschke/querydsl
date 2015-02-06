package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * ActsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class ActsEntity {

    private Integer actNo;

    private Integer animalId;

    private String description;

    private Integer duration;

    private Integer equipCode;

    private Integer operator;

    public Integer getActNo() {
        return actNo;
    }

    public void setActNo(Integer actNo) {
        this.actNo = actNo;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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

}

