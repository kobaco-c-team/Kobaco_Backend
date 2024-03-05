package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Trend {
    private Long id;
    private String trendKeyword;

    public static Trend of(Long id, String trendKeyword) {
        return new Trend(id, trendKeyword);
    }
}
