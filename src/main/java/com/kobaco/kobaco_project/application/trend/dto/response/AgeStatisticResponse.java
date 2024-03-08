package com.kobaco.kobaco_project.application.trend.dto.response;

import com.kobaco.kobaco_project.domain.trend.model.Age;
public record AgeStatisticResponse(String ageType, Long ratio) {
    public static AgeStatisticResponse of(Age age) {
        return new AgeStatisticResponse(age.getAgeType().getDescription(), age.getRatio());
    }
}
