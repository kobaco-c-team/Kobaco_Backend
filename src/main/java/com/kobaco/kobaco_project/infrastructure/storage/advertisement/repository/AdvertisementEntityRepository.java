package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementEntityRepository extends JpaRepository<AdvertisementEntity, Long> {
    Optional<AdvertisementEntity> findAdvertisementEntityById(Long id);
}
