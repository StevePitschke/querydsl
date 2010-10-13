package com.mysema.query.mongodb.domain;

import java.math.BigDecimal;

import com.mysema.query.annotations.QueryEmbeddable;

@QueryEmbeddable
public final class City {
    
    public City(String name, BigDecimal latitude, BigDecimal longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public final String name;
    public final BigDecimal latitude;
    public final BigDecimal longitude;
}