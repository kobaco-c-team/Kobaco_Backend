package com.kobaco.kobaco_project.application.trend.dto.response;

public record MonthStatisticResponse(String month, Long ratio) {
    public static MonthStatisticResponse of(String month, Long ratio) {
        return new MonthStatisticResponse(month, ratio);
    }
}
