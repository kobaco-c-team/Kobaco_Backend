package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.AgeEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgeEntityRepository extends JpaRepository<AgeEntity, Long> {
    List<AgeEntity> findAllByTrendId(Long trendId);
}
