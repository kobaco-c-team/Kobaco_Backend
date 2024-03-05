package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Age {
    private AgeType ageType;
    private Long ratio;

    public static Age of(AgeType ageType, Long ratio) {
        return new Age(ageType, ratio);
    }
}
