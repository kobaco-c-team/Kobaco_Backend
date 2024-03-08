package com.kobaco.kobaco_project.domain.trend.model;

public enum GenderType {
    FEMALE("여성"), MALE("남성");

    private String description;

    GenderType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
