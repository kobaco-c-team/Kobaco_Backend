package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.ContentArchivingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContentArchivingEntityRepository extends JpaRepository<ContentArchivingEntity, Long> {
    List<ContentArchivingEntity> findAllByKeywordEntityName(String kwyName);
}
