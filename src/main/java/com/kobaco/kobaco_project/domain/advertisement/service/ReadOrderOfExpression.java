package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
public class ReadOrderOfExpression {
    private final ExpressionRepository expressionRepository;

    public String readFirstExpression(Long advertisementId){
        return this.expressionRepository.findAllByAdvertisementId(advertisementId)
                .stream()
                .collect(Collectors.groupingBy(Expression::getType, Collectors.counting()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .toString();
    }

    public String readSecondExpression(Long advertisementId){
        return this.expressionRepository.findAllByAdvertisementId(advertisementId)
                .stream()
                .collect(Collectors.groupingBy(Expression::getType, Collectors.counting()))
                .entrySet().stream()
                // 먼저 빈도의 내림차순으로 정렬
                .sorted(Map.Entry.<ExpressionType, Long>comparingByValue().reversed())
                .skip(1) // 첫 번째(가장 많이 나타나는) 요소 건너뛰기
                .findFirst() // 두 번째로 많이 나타나는 요소 가져오기
                .map(Map.Entry::getKey)
                .toString();
    }


}
