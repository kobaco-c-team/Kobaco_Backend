package com.kobaco.kobaco_project.domain.expression.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.expression.Expression;
import com.kobaco.kobaco_project.domain.expression.ExpressionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadAllExpressions {
    private final ExpressionRepository expressionRepository;

    public List<Expression> readAllExpressions(Long advertisementId){
        return expressionRepository.findAllByAdvertisementId(advertisementId);
    }
}
