package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.GenderEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderEntityRepository extends JpaRepository<GenderEntity, Long> {
    List<GenderEntity> findAllByTrendId(Long trendId);
}
