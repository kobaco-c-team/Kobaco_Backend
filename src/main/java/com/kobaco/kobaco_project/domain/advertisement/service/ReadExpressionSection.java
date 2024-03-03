package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementExpressionResponse;
import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionSection;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
public class ReadExpressionSection {

    private final ExpressionRepository expressionRepository;

    public List<ExpressionSection> readExpressionSection(Long advertisementId){
        List<Expression> expressionList = this.expressionRepository.findAllByAdvertisementId(advertisementId);

        expressionList.sort((a,b) -> Double.compare(a.getTime(), b.getTime()));
        List<ExpressionSection> sectionList = new ArrayList<>();

        for(int i=0;i<expressionList.size();i+=10){
            String firstExpression = extractFirstExpression(expressionList.subList(i, i+9));
            sectionList.add(ExpressionSection.builder()
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

}
