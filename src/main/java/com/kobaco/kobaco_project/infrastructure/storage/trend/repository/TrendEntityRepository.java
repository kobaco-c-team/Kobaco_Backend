package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.TrendEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrendEntityRepository extends JpaRepository<TrendEntity, Long> {
    Optional<TrendEntity> findByTrendKeyword(String trendKeyword);
}
