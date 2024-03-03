package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
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
