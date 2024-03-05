package com.kobaco.kobaco_project.application.trend.dto.response;

import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.domain.trend.model.GenderType;

public record GenderStatisticResponse(GenderType genderType, Long ratio) {
    public static GenderStatisticResponse of (Gender gender) {
        return new GenderStatisticResponse(gender.getGenderType(), gender.getRatio());
    }
}
