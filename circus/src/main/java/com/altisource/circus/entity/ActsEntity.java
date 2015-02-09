package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * ActsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class ActsEntity {

    private Integer actNo;

    private List<Integer> animalId;

    private String description;

    private Integer duration;

    private List<Integer> equipCode;

    private List<Integer> operator;

    public Integer getActNo() {
        return actNo;
    }

    public void setActNo(Integer actNo) {
        this.actNo = actNo;
    }

    public List<Integer> getAnimalId() {
        return animalId;
    }

    public void setAnimalId(List<Integer> animalId) {
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

}

