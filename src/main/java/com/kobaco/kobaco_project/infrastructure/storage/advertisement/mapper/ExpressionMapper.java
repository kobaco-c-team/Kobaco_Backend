package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Expression;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ExpressionEntity;
import org.springframework.stereotype.Component;

@Component
public class ExpressionMapper {
    public Expression toDomain(final ExpressionEntity expressionEntity) {
        return Expression.of(
                expressionEntity.getId(),
                expressionEntity.getExpressionType().getDescription(),
                expressionEntity.getTime(),
                expressionEntity.getAdvertisementEntity().getId()
        );
    }
}
