package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExpressionWithPercentage {
    private ExpressionType type;
    private Long percentage;

    public static ExpressionWithPercentage of(ExpressionType expressionType, Long percentage){
        return new ExpressionWithPercentage(expressionType, percentage);
    }
}
