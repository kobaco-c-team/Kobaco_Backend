package com.kobaco.kobaco_project.application.trend.dto.response;

import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.domain.trend.model.AgeType;

public record AgeStatisticResponse(AgeType ageType, Long ratio) {
    public static AgeStatisticResponse of(Age age) {
        return new AgeStatisticResponse(age.getAgeType(), age.getRatio());
    }
}
