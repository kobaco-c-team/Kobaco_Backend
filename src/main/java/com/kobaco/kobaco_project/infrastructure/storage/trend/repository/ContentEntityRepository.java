package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.ContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentEntityRepository extends JpaRepository<ContentEntity, Long> {
    List<ContentEntity> findByTrendEntityTrendKeywordAndPlatform(String kwdVal, String platform);
}
