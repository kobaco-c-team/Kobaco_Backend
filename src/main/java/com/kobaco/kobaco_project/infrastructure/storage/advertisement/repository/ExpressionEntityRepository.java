package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ExpressionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

public interface ExpressionEntityRepository extends JpaRepository<ExpressionEntity, Long> {
    Optional<List<ExpressionEntity>> findAllByAdvertisementId(Long AdvertisementId);
    @Query("select e from ExpressionEntity e where e.advertisementId in :advertisementIds")
    List<ExpressionEntity> findAllByAdvertisementIds(List<Long> advertisementIds);
}
