package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class CalculateAdvertisementTime {

    private final ExpressionRepository expressionRepository;

    public Map<Long, Long> calculateAdvertisementTimeByIds(List<Long> advertisementIds) {
        List<Expression> expressionList = expressionRepository.findExpressionIdsByAdvertisementIds(advertisementIds);
        return expressionList.stream()
                .collect(
                        Collectors.groupingBy(
                                Expression::getAdvertisement_id,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingDouble(Expression::getTime)),
                                        optional -> optional.map(Expression::getTime).orElse(0.0).longValue()
                                )
                        )
                );
    }

}
