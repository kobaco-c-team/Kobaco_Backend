package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.Getter;

@Getter
public enum ExpressionType {
    SMILING("미소짓는"), SAD("슬픈"), SURPRISED("놀란"),
    EXPRESSIONLESS("무표정"), ANGRY("화난"), FROWN("찡그린"),
    SCARED("겁난");


    private String description;

    ExpressionType(String description){
        this.description = description;
    }
}
