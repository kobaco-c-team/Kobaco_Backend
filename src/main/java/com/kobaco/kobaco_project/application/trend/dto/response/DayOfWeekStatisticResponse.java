package com.kobaco.kobaco_project.application.trend.dto.response;

public record DayOfWeekStatisticResponse(String dayOfWeek, Long ratio) {
    public static DayOfWeekStatisticResponse of(String dayOfWeek, Long ratio) {
        return new DayOfWeekStatisticResponse(dayOfWeek, ratio);
    }
}
