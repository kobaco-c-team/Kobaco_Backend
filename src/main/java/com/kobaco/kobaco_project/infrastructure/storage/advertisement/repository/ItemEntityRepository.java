package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ItemEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemEntityRepository extends JpaRepository<ItemEntity, Long> {
    List<ItemEntity> findAllByAdvertisementEntityId(Long advertisementId);
}
