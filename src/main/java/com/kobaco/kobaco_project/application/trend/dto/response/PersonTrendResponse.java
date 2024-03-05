package com.kobaco.kobaco_project.application.trend.dto.response;

import java.util.List;

public record PersonTrendResponse(List<AgeStatisticResponse> ageStatisticResponseList,
                                  List<GenderStatisticResponse> genderStatisticResponseList) {
    public static PersonTrendResponse of(List<AgeStatisticResponse> ageStatisticResponseList,
                                          List<GenderStatisticResponse> genderStatisticResponseList) {
        return new PersonTrendResponse(ageStatisticResponseList, genderStatisticResponseList);
    }
}
