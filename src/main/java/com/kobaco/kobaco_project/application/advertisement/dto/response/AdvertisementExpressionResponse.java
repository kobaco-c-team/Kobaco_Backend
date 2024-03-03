package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
public record AdvertisementExpressionResponse (List<Section> sectionList, String firstExpression, String secondExpression){
    @Builder
    public record Section(Integer startTime, Integer endTime, String expressionType){
    }

    public static AdvertisementExpressionResponse from(final List<Expression> expressionList){
        return AdvertisementExpressionResponse.builder()
                .sectionList(mappingSection(expressionList))
                .firstExpression(extractFirstExpression(expressionList))
                .secondExpression(extractSecondExpression(expressionList))
                .build();
    }

    private static List<Section> mappingSection(List<Expression> expressionList){
        expressionList.sort((a,b) -> Double.compare(a.getTime(), b.getTime()));
        List<Section> sectionList = new ArrayList<>();

        for(int i=0;i<expressionList.size();i+=10){
            String firstExpression = extractFirstExpression(expressionList.subList(i, i+9));
            sectionList.add(Section.builder()
                            .startTime(i/10 *5)
                            .endTime((i+10)/2)
                            .expressionType(firstExpression)
                            .build());
        }
        return sectionList;

    }

    private static String extractFirstExpression(List<Expression> expressionList){
        return expressionList.stream()
                .collect(Collectors.groupingBy(Expression::getType, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toString();
    }

    private static String extractSecondExpression(List<Expression> expressionList){
        return expressionList.stream()
                .collect(Collectors.groupingBy(Expression::getType, Collectors.counting()))
                .entrySet().stream()
                // 먼저 빈도의 내림차순으로 정렬
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .skip(1) // 첫 번째(가장 많이 나타나는) 요소 건너뛰기
                .findFirst() // 두 번째로 많이 나타나는 요소 가져오기
                .map(Map.Entry::getKey)
                .toString();
    }
}
