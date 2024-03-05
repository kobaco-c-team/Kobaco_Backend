package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.response.AgeStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.DayOfWeekStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.TimeStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.GenderStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.MonthStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.PersonStatisticResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.domain.trend.model.Trend;
import com.kobaco.kobaco_project.domain.trend.service.CalculateSearchVolume;
import com.kobaco.kobaco_project.domain.trend.service.ReadAgeTrend;
import com.kobaco.kobaco_project.domain.trend.service.ReadGenderTrend;
import com.kobaco.kobaco_project.domain.trend.service.ReadTrend;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {

    private final ReadTrend readTrend;
    private final ReadAgeTrend readAgeTrend;
    private final ReadGenderTrend readGenderTrend;
    private final CalculateSearchVolume caculateSearchVolume;

    public PersonStatisticResponse getPersonStatistic(String trendKwd) {
        Trend trend = readTrend.getTrend(trendKwd);
        List<Age> ages = readAgeTrend.getAgesTrend(trend.getId());
        List<Gender> genders = readGenderTrend.getGendersTrend(trend.getId());
        return PersonStatisticResponse.of(
            ages.stream()
                .map(AgeStatisticResponse::of)
                .collect(Collectors.toList()),
            genders.stream()
                .map(GenderStatisticResponse::of)
                .collect(Collectors.toList())

        );
    }

    public TimeStatisticResponse getTimeStatistic(String trendKwd) {
        Trend trend = readTrend.getTrend(trendKwd);
        Map<String, Object> timeStatisticMap = caculateSearchVolume.getTimeStatistic(trend.getId());
        Map<String, Long> monthStatisticMap = (Map<String, Long>) timeStatisticMap.get("monthStatisticMap");
        Map<String, Long> dayOfWeekStatisticMap = (Map<String, Long>) timeStatisticMap.get("dayOfWeekStatisticMap");

        return TimeStatisticResponse.of(
                monthStatisticMap.entrySet().stream()
                        .map(e -> MonthStatisticResponse.of(e.getKey(), e.getValue()))
                        .collect(Collectors.toList()),
                dayOfWeekStatisticMap.entrySet().stream()
                        .map(e -> DayOfWeekStatisticResponse.of(e.getKey(), e.getValue()))
                        .collect(Collectors.toList())
        );
    }
}
