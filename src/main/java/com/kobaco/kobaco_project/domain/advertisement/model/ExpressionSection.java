package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExpressionSection {
    private Integer startTime;
    private Integer endTime;
    private String expressionType;

    public static ExpressionSection of(Integer startTime, Integer endTime, String expressionType){
        return new ExpressionSection(startTime,endTime,expressionType);
    }
}
