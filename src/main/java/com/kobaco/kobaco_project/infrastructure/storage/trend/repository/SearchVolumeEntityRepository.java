package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.SearchVolumeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchVolumeEntityRepository extends JpaRepository<SearchVolumeEntity, Long> {
    List<SearchVolumeEntity> findAllByTrendId(Long trendId);
}
