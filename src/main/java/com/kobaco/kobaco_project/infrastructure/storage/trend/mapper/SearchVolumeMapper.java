package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.trend.model.SearchVolume;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.SearchVolumeEntity;
import org.springframework.stereotype.Component;

@Component
public class SearchVolumeMapper {
    public SearchVolume toDomain(final SearchVolumeEntity searchVolumeEntity) {
        return SearchVolume.of(searchVolumeEntity.getSearchDate(), searchVolumeEntity.getVolume());
    }
}
