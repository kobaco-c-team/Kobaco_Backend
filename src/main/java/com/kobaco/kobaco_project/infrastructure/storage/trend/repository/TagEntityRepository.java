package com.kobaco.kobaco_project.infrastructure.storage.trend.repository;

import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface TagEntityRepository extends JpaRepository<TagEntity, Long> {
    List<TagEntity> findAllByKeywordEntityNameAndPlatform(String kwdVal, String platform);

    List<TagEntity> findAllByContentEntityIdAndPlatform(Long id, String platform);
}
