package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AdvertisementEntityRepository extends JpaRepository<AdvertisementEntity, Long> {
    Optional<AdvertisementEntity> findAdvertisementEntityById(Long id);

    @Modifying
    @Query("update AdvertisementEntity a set a.isArchived = :isArchived, a.archivedAt = :archivedAt where a.id = :id")
    void updateArchivedStatus(Long id, Boolean isArchived, LocalDateTime archivedAt);

}
