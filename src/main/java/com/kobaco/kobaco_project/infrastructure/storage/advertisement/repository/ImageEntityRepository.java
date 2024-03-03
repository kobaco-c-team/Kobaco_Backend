package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ExpressionEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageEntityRepository extends JpaRepository<ImageEntity, Long> {
    List<ImageEntity> findAllByType(String type);
}
