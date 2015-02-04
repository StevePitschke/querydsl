package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * PersonnelDepAssocEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class PersonnelDepAssocEntity {

    private Integer badgeNo;

    private java.sql.Date depDob;

    private String depName;

    private String depRelation;

    public Integer getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(Integer badgeNo) {
        this.badgeNo = badgeNo;
    }

    public java.sql.Date getDepDob() {
        return depDob;
    }

    public void setDepDob(java.sql.Date depDob) {
        this.depDob = depDob;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepRelation() {
        return depRelation;
    }

    public void setDepRelation(String depRelation) {
        this.depRelation = depRelation;
    }

}

