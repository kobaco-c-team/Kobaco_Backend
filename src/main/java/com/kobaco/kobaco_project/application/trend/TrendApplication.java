package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.response.AgeStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.GenderStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.PersonTrendResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.domain.trend.model.Trend;
import com.kobaco.kobaco_project.domain.trend.service.ReadAgeTrend;
import com.kobaco.kobaco_project.domain.trend.service.ReadGenderTrend;
import com.kobaco.kobaco_project.domain.trend.service.ReadTrend;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {

    private final ReadTrend readTrend;
    private final ReadAgeTrend readAgeTrend;
    private final ReadGenderTrend readGenderTrend;

    public PersonTrendResponse getPersonTrend(String trendKwd) {
        Trend trend = readTrend.getTrend(trendKwd);
        List<Age> ages = readAgeTrend.getAgesTrend(trend.getId());
        List<Gender> genders = readGenderTrend.getGendersTrend(trend.getId());
        return PersonTrendResponse.of(
            ages.stream()
                .map(AgeStatisticResponse::of)
                .collect(Collectors.toList()),
            genders.stream()
                .map(GenderStatisticResponse::of)
                .collect(Collectors.toList())

        );
    }
}
