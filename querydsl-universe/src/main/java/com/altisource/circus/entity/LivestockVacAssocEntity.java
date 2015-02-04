package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * LivestockVacAssocEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class LivestockVacAssocEntity {

    private Integer animalId;

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

