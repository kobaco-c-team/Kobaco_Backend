package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.application.advertisement.dto.response.ExpressionResponse;
import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionWithPercentage;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@DomainService
@RequiredArgsConstructor
public class ReadOrderOfExpression {
    private final ExpressionRepository expressionRepository;

    public List<ExpressionWithPercentage> readOrderOfExpression(Long advertisementId) {
        Map<ExpressionType, Long> expressionCounts = expressionRepository.findAllByAdvertisementId(advertisementId)
                .stream()
                .collect(Collectors.groupingBy(Expression::getType, Collectors.counting()));

        long totalExpressions = expressionCounts.values().stream().mapToLong(Long::longValue).sum();

        return expressionCounts
                .entrySet()
                .stream()
                .sorted(Map.Entry.<ExpressionType, Long>comparingByValue().reversed())
                .map(entry -> ExpressionWithPercentage.of(entry.getKey(),  (long) ( (entry.getValue()/ (double) totalExpressions)*100) ))
                .limit(3)
                .toList();

    }
}
