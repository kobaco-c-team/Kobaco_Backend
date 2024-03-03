package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
public record AdvertisementExpressionResponse (List<ExpressionSectionResponse> sectionList, String firstExpression, String secondExpression){

    public static AdvertisementExpressionResponse of(final List<ExpressionSectionResponse> sectionList, String firstExpression, String secondExpression){
        return new AdvertisementExpressionResponse(sectionList, firstExpression,secondExpression);
    }
}
