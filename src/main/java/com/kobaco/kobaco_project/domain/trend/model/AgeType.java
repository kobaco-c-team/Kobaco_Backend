package com.kobaco.kobaco_project.domain.trend.model;

public enum AgeType {
    TEEN("10대"), TWENTY("20대"), THIRTY("30대"), FORTY("40대"), FIFTY("50대");

    private String description;

    AgeType(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
