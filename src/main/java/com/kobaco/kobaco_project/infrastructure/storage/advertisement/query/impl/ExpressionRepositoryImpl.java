package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.AdvertisementEntityRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ExpressionEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.ExpressionMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.ExpressionEntityRepository;
import java.util.Collections;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExpressionRepositoryImpl implements ExpressionRepository {
    private final ExpressionEntityRepository expressionEntityRepository;
    private final AdvertisementEntityRepository advertisementEntityRepository;
    private final ExpressionMapper expressionMapper;
    @Override
    public List<Expression> findAllByAdvertisementId(Long advertisement_id) {
        List<ExpressionEntity> expressionEntityList = expressionEntityRepository.findAllByAdvertisementEntityId(advertisement_id);

        List<Expression> expressionList = new ArrayList<>();
        for(ExpressionEntity expressionEntity : expressionEntityList){
            expressionList.add(expressionMapper.toDomain(expressionEntity));
        }

        return expressionList;
    }

    @Override
    public List<Expression> findExpressionByAdvertisementIds(List<Long> advertisementIds) {
        List<ExpressionEntity> expressionEntityList = expressionEntityRepository.findAllByAdvertisementIds(advertisementIds);
        return Optional.ofNullable(expressionEntityList)
                .map(list -> list.stream().map(expressionMapper::toDomain).toList())
                .orElse(Collections.emptyList());
    }
}
