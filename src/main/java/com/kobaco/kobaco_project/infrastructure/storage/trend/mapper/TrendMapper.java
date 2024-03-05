package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.trend.model.Trend;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.TrendEntity;
import org.springframework.stereotype.Component;

@Component
public class TrendMapper {
    public Trend toDomain(final TrendEntity trendEntity) {
        return Trend.of(trendEntity.getId(), trendEntity.getTrendKeyword());
    }
}
