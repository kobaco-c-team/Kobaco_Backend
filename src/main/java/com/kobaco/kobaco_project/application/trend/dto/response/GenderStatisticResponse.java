package com.kobaco.kobaco_project.application.trend.dto.response;

import com.kobaco.kobaco_project.domain.trend.model.Gender;

public record GenderStatisticResponse(String genderType, Long ratio) {
    public static GenderStatisticResponse of (Gender gender) {
        return new GenderStatisticResponse(gender.getGenderType().getDescription(), gender.getRatio());
    }
}
