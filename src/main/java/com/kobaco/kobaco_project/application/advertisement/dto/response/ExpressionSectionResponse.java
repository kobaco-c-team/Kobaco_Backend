package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionSection;
import lombok.Builder;

@Builder
public record ExpressionSectionResponse(Integer startTime, Integer endTime, String expressionType){

    public static ExpressionSectionResponse of(ExpressionSection expressionSection){
        return new ExpressionSectionResponse(expressionSection.getStartTime(),expressionSection.getEndTime(),expressionSection.getExpressionType());
    }
}
