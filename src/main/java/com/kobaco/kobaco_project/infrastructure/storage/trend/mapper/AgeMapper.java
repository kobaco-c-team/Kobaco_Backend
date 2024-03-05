package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.AgeEntity;
import org.springframework.stereotype.Component;

@Component
public class AgeMapper {
    public Age toDomain(final AgeEntity ageEntity) {
        return Age.of(ageEntity.getAgeType(), ageEntity.getRatio());
    }
}
