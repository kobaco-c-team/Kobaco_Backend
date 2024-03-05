package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.MoodEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MoodEntityRepository extends JpaRepository<MoodEntity, Long> {
    List<MoodEntity> findAllByAdvertisementEntityId(Long advertisementId);
    List<MoodEntity> findAllByType(String type);
    @Query("select m from MoodEntity m where m.advertisementEntity.id in :advertisementIds")
    List<MoodEntity> findAllByAdvertisementIds(List<Long> advertisementIds);
}
