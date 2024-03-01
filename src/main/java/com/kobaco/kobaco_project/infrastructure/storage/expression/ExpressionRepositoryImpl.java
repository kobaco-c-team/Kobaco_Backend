package com.kobaco.kobaco_project.infrastructure.storage.expression;

import com.kobaco.kobaco_project.domain.expression.Expression;
import com.kobaco.kobaco_project.domain.expression.ExpressionRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.AdvertisementEntityRepository;
import com.kobaco.kobaco_project.infrastructure.storage.expression.entity.ExpressionEntity;
import com.kobaco.kobaco_project.infrastructure.storage.expression.mapper.ExpressionMapper;
import com.kobaco.kobaco_project.infrastructure.storage.expression.repository.ExpressionEntityRepository;
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
        AdvertisementEntity advertisementEntity = this.advertisementEntityRepository.findAdvertisementEntityById(advertisement_id).orElseThrow(() -> new RuntimeException("advertisement not found"));;
        List<ExpressionEntity> expressionEntityList = this.expressionEntityRepository.findAllByAdvertisementEntity(advertisementEntity).orElseThrow(() -> new RuntimeException("expression not found"));

        List<Expression> expressionList = new ArrayList<>();
        for(ExpressionEntity expressionEntity : expressionEntityList){
            expressionList.add(this.expressionMapper.toDomain(expressionEntity));
        }

        return expressionList;
    }
}
