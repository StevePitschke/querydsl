package com.altisource.circus.entity;

import java.util.List;
import javax.annotation.Generated;

/**
 * ConcessionsEntity is a Querydsl bean type
 */
@Generated("com.mysema.query.codegen.BeanSerializer")
public class ConcessionsEntity {

    private Integer concNo;

    private String description;

    private List<Integer> equipCode;

    private List<Integer> operator;

    public Integer getConcNo() {
        return concNo;
    }

    public void setConcNo(Integer concNo) {
        this.concNo = concNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

