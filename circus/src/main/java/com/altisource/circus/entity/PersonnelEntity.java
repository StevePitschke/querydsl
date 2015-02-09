package com.altisource.circus.entity;

import javax.annotation.Generated;

/**
 * PersonnelEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class PersonnelEntity {

    private String adr1;

    private String adr2;

    private String adr3;

    private Integer badgeNo;

    private String benefits;

    private java.sql.Date dob;

    private String name;

    private String phone;

    public String getAdr1() {
        return adr1;
    }

    public void setAdr1(String adr1) {
        this.adr1 = adr1;
    }

    public String getAdr2() {
        return adr2;
    }

    public void setAdr2(String adr2) {
        this.adr2 = adr2;
    }

    public String getAdr3() {
        return adr3;
    }

    public void setAdr3(String adr3) {
        this.adr3 = adr3;
    }

    public Integer getBadgeNo() {
        return badgeNo;
    }

    public void setBadgeNo(Integer badgeNo) {
        this.badgeNo = badgeNo;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}

