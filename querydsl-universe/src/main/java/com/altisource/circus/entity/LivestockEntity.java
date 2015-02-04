package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * LivestockEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class LivestockEntity {

    private Integer animalId;

    private Double cost;

    private String description;

    private java.sql.Date dob;

    private Integer estLife;

    private String name;

    private String origin;

    private String use;

    private String vacCert;

    private java.sql.Date vacDate;

    private java.sql.Date vacNext;

    private String vacType;

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public Integer getEstLife() {
        return estLife;
    }

    public void setEstLife(Integer estLife) {
        this.estLife = estLife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getVacCert() {
        return vacCert;
    }

    public void setVacCert(String vacCert) {
        this.vacCert = vacCert;
    }

    public java.sql.Date getVacDate() {
        return vacDate;
    }

    public void setVacDate(java.sql.Date vacDate) {
        this.vacDate = vacDate;
    }

    public java.sql.Date getVacNext() {
        return vacNext;
    }

    public void setVacNext(java.sql.Date vacNext) {
        this.vacNext = vacNext;
    }

    public String getVacType() {
        return vacType;
    }

    public void setVacType(String vacType) {
        this.vacType = vacType;
    }

}

