package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementMapper {

    public Advertisement toDomain(final AdvertisementEntity advertisementEntity) {
        return Advertisement.of(
            advertisementEntity.getId(),
            advertisementEntity.getTitle(),
            advertisementEntity.getVideoUrl(),
            advertisementEntity.getAdvertiser(),
            advertisementEntity.getAgency(),
            advertisementEntity.getManufacturer(),
            advertisementEntity.getIsArchived(),
            advertisementEntity.getArchivedAt(),
            advertisementEntity.getCreatedAt()
        );
    }

    public AdvertisementEntity toEntity(final Advertisement advertisement) {
        return AdvertisementEntity.of(
            advertisement.getId(),
            advertisement.getTitle(),
            advertisement.getVideoUrl(),
            advertisement.getAdvertiser(),
            advertisement.getAgency(),
            advertisement.getManufacturer(),
            advertisement.getIsArchived(),
            advertisement.getArchivedAt()
        );
    }
}
