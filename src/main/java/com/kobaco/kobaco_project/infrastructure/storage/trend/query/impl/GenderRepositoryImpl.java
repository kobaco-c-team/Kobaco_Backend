package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.domain.trend.query.GenderRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.GenderMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.GenderEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GenderRepositoryImpl implements GenderRepository {
    private final GenderEntityRepository genderEntityRepository;
    private final GenderMapper genderMapper;

    @Override
    public List<Gender> findAllByTrendId(Long trendId) {
        return genderEntityRepository.findAllByTrendId(trendId).stream()
                .map(genderMapper::toDomain)
                .toList();
    }
}
