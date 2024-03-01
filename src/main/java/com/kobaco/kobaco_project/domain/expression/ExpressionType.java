package com.kobaco.kobaco_project.domain.expression;

import lombok.Getter;

@Getter
public enum ExpressionType {
    SMILING("미소짓는"), SAD("슬픈"), SURPRISED("놀란");

    private String description;

    ExpressionType(String description){
        this.description = description;
    }
}
