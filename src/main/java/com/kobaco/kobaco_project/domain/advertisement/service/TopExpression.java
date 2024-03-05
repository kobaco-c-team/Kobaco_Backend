package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class TopExpression {

    private final ExpressionRepository expressionRepository;

    public Map<Long, ExpressionType> getTopExpressionByAdvertisementIds(final List<Long> advertisementIds) {
        List<Expression> expressionList = expressionRepository.findExpressionByAdvertisementIds(advertisementIds);
        return expressionList.stream()
                .collect(
                        Collectors.groupingBy(
                                Expression::getAdvertisement_id,
                                Collectors.groupingBy(
                                        Expression::getType, 
                                        Collectors.counting()
                                )
                        )
                )
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().entrySet().stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null)
                ));
    }


}
