package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpressionEntityRepository extends JpaRepository<ExpressionEntity, Long> {
    Optional<List<ExpressionEntity>> findAllByAdvertisementId(Long AdvertisementId);
}
