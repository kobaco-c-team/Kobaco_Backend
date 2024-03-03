package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Long> {
    List<PlaceEntity> findAllByAdvertisementEntityId(Long advertisementId);
}
