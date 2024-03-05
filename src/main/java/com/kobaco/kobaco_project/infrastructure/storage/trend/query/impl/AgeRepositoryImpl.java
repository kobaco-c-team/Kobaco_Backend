package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.domain.trend.query.AgeRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.AgeEntity;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.AgeMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.AgeEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AgeRepositoryImpl implements AgeRepository {
    private final AgeEntityRepository ageEntityRepository;
    private final AgeMapper ageMapper;

    @Override
    public List<Age> findAllByTrendId(Long trendId) {
        return ageEntityRepository.findAllByTrendId(trendId).stream()
                .map(ageMapper::toDomain)
                .toList();
    }
}
