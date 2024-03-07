package com.kobaco.kobaco_project.application.trend.dto.response;

import java.util.List;

public record PersonStatisticResponse(List<AgeStatisticResponse> ageStatisticResponseList,
                                      List<GenderStatisticResponse> genderStatisticResponseList) {
    public static PersonStatisticResponse of(List<AgeStatisticResponse> ageStatisticResponseList,
                                             List<GenderStatisticResponse> genderStatisticResponseList) {
        return new PersonStatisticResponse(ageStatisticResponseList, genderStatisticResponseList);
    }
}
