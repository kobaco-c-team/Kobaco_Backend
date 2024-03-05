package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.Trend;
import com.kobaco.kobaco_project.domain.trend.query.TrendRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.TrendMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.TrendEntityRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TrendRepositoryImpl implements TrendRepository {
    private final TrendEntityRepository trendEntityRepository;
    private final TrendMapper trendMapper;

    @Override
    public Optional<Trend> findByTrendKeyword(String trendKwd) {
        return trendEntityRepository.findByTrendKeyword(trendKwd)
                .map(trendMapper::toDomain);
    }
}
