package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Gender {
    private GenderType genderType;
    private Long ratio;

    public static Gender of(GenderType genderType, Long ratio) {
        return new Gender(genderType, ratio);
    }
}
