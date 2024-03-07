package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionWithPercentage;

public record ExpressionResponse(String expression, Long percentage) {
    public static ExpressionResponse from(ExpressionWithPercentage expression){
        return new ExpressionResponse(expression.getType().getDescription(), expression.getPercentage());
    }
}
