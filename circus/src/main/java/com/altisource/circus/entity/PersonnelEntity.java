package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * PersonnelEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class PersonnelEntity {

    private List<Integer> actNo;

    private List<Double> actPay;

    private String adr1;

    private String adr2;

    private String adr3;

    private Integer badgeNo;

    private String benefits;

    private List<java.sql.Date> depDob;

    private List<String> depName;

    private List<String> depRelation;

    private java.sql.Date dob;

    private List<Integer> equipCode;

    private List<Double> equipPay;

    private String name;

    private String phone;

    private List<Integer> rideId;

    private List<Double> ridePay;

    public List<Integer> getActNo() {
        return actNo;
    }

    public void setActNo(List<Integer> actNo) {
        this.actNo = actNo;
    }

    public List<Double> getActPay() {
        return actPay;
    }

    public void setActPay(List<Double> actPay) {
        this.actPay = actPay;
    }

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

    public List<java.sql.Date> getDepDob() {
        return depDob;
    }

    public void setDepDob(List<java.sql.Date> depDob) {
        this.depDob = depDob;
    }

    public List<String> getDepName() {
        return depName;
    }

    public void setDepName(List<String> depName) {
        this.depName = depName;
    }

    public List<String> getDepRelation() {
        return depRelation;
    }

    public void setDepRelation(List<String> depRelation) {
        this.depRelation = depRelation;
    }

    public java.sql.Date getDob() {
        return dob;
    }

    public void setDob(java.sql.Date dob) {
        this.dob = dob;
    }

    public List<Integer> getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(List<Integer> equipCode) {
        this.equipCode = equipCode;
    }

    public List<Double> getEquipPay() {
        return equipPay;
    }

    public void setEquipPay(List<Double> equipPay) {
        this.equipPay = equipPay;
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

    public List<Integer> getRideId() {
        return rideId;
    }

    public void setRideId(List<Integer> rideId) {
        this.rideId = rideId;
    }

    public List<Double> getRidePay() {
        return ridePay;
    }

    public void setRidePay(List<Double> ridePay) {
        this.ridePay = ridePay;
    }

}

