package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.SearchVolume;
import com.kobaco.kobaco_project.domain.trend.query.SearchVolumeRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.SearchVolumeMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.SearchVolumeEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SearchVolumeRepositoryImpl implements SearchVolumeRepository {
    private final SearchVolumeEntityRepository searchVolumeEntityRepository;
    private final SearchVolumeMapper searchVolumeMapper;

    @Override
    public List<SearchVolume> findAllByTrendId(Long trendId) {
        return searchVolumeEntityRepository.findAllByTrendId(trendId).stream()
                .map(searchVolumeMapper::toDomain)
                .toList();
    }
}
