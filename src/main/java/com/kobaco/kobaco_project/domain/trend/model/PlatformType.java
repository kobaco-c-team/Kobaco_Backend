package com.kobaco.kobaco_project.domain.trend.model;

import lombok.Getter;

@Getter
public enum PlatformType {

    INSTAGRAM("INSTAGRAM"), YOUTUBE("YOUTUBE");

    private String description;

    PlatformType(String description){
        this.description = description;
    }
}
