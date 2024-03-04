package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.domain.advertisement.query.ExpressionRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.AdvertisementEntityRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ExpressionEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.ExpressionMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.ExpressionEntityRepository;
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
        List<ExpressionEntity> expressionEntityList = this.expressionEntityRepository.findAllByAdvertisementId(advertisement_id).orElseThrow(() -> new RuntimeException("expression not found"));

        List<Expression> expressionList = new ArrayList<>();
        for(ExpressionEntity expressionEntity : expressionEntityList){
            expressionList.add(this.expressionMapper.toDomain(expressionEntity));
        }

        return expressionList;
    }

    @Override
    public List<Expression> findExpressionIdsByAdvertisementIds(List<Long> advertisementIds) {
        List<ExpressionEntity> expressionEntityList = this.expressionEntityRepository.findAllByAdvertisementIds(advertisementIds);
        return expressionEntityList
                .stream()
                .map(expressionMapper::toDomain)
                .toList();
    }
}
