package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * EngagementsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class EngagementsEntity {

    private List<Integer> actNo;

    private Double advance;

    private List<Integer> concId;

    private List<Double> concRevenue;

    private List<Integer> concTickets;

    private java.sql.Date date;

    private List<Integer> gateNumber;

    private List<Double> gateRevenue;

    private List<Integer> gateTickets;

    private Integer labor;

    private String locationCode;

    private Double pay;

    private List<Integer> rideId;

    private List<Double> rideRevenue;

    private List<Integer> rideTickets;

    private java.sql.Time time;

    public List<Integer> getActNo() {
        return actNo;
    }

    public void setActNo(List<Integer> actNo) {
        this.actNo = actNo;
    }

    public Double getAdvance() {
        return advance;
    }

    public void setAdvance(Double advance) {
        this.advance = advance;
    }

    public List<Integer> getConcId() {
        return concId;
    }

    public void setConcId(List<Integer> concId) {
        this.concId = concId;
    }

    public List<Double> getConcRevenue() {
        return concRevenue;
    }

    public void setConcRevenue(List<Double> concRevenue) {
        this.concRevenue = concRevenue;
    }

    public List<Integer> getConcTickets() {
        return concTickets;
    }

    public void setConcTickets(List<Integer> concTickets) {
        this.concTickets = concTickets;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public List<Integer> getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(List<Integer> gateNumber) {
        this.gateNumber = gateNumber;
    }

    public List<Double> getGateRevenue() {
        return gateRevenue;
    }

    public void setGateRevenue(List<Double> gateRevenue) {
        this.gateRevenue = gateRevenue;
    }

    public List<Integer> getGateTickets() {
        return gateTickets;
    }

    public void setGateTickets(List<Integer> gateTickets) {
        this.gateTickets = gateTickets;
    }

    public Integer getLabor() {
        return labor;
    }

    public void setLabor(Integer labor) {
        this.labor = labor;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public Double getPay() {
        return pay;
    }

    public void setPay(Double pay) {
        this.pay = pay;
    }

    public List<Integer> getRideId() {
        return rideId;
    }

    public void setRideId(List<Integer> rideId) {
        this.rideId = rideId;
    }

    public List<Double> getRideRevenue() {
        return rideRevenue;
    }

    public void setRideRevenue(List<Double> rideRevenue) {
        this.rideRevenue = rideRevenue;
    }

    public List<Integer> getRideTickets() {
        return rideTickets;
    }

    public void setRideTickets(List<Integer> rideTickets) {
        this.rideTickets = rideTickets;
    }

    public java.sql.Time getTime() {
        return time;
    }

    public void setTime(java.sql.Time time) {
        this.time = time;
    }

}

