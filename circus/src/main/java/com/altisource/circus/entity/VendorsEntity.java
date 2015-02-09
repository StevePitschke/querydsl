package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * VendorsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class VendorsEntity {

    private String adr1;

    private String adr2;

    private String adr3;

    private String company;

    private String contact;

    private List<Integer> equipCode;

    private String fax;

    private String phone;

    private String terms;

    private Integer vendorCode;

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<Integer> getEquipCode() {
        return equipCode;
    }

    public void setEquipCode(List<Integer> equipCode) {
        this.equipCode = equipCode;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Integer getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(Integer vendorCode) {
        this.vendorCode = vendorCode;
    }

}

