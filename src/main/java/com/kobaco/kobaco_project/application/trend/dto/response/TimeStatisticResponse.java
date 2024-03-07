package com.kobaco.kobaco_project.application.trend.dto.response;

import java.util.List;

public record TimeStatisticResponse(List<MonthStatisticResponse> monthStatisticResponseList,
                                    List<DayOfWeekStatisticResponse> dayOfWeekStatisticResponseList) {
    public static TimeStatisticResponse of(List<MonthStatisticResponse> monthStatisticResponseList,
                                           List<DayOfWeekStatisticResponse> dayOfWeekStatisticResponseList) {
        return new TimeStatisticResponse(monthStatisticResponseList, dayOfWeekStatisticResponseList);
    }
}
