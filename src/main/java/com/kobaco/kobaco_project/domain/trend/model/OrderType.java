package com.kobaco.kobaco_project.domain.trend.model;

import lombok.Getter;

@Getter
public enum OrderType {
    RECENT("RECENT"), RELEVANT("RELEVANT");

    private String description;

    OrderType(String description){
        this.description = description;
    }
}
