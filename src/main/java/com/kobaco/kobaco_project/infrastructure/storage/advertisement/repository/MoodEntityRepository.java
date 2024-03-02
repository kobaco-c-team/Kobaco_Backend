package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.MoodEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodEntityRepository extends JpaRepository<MoodEntity, Long> {
    List<MoodEntity> findAllByAdvertisementEntityId(Long advertisementId);
}
