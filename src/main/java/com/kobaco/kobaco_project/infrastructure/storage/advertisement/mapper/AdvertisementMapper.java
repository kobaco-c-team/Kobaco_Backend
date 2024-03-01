package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.Advertisement;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import org.springframework.stereotype.Component;

@Component
public class AdvertisementMapper {

    public Advertisement toDomain(final AdvertisementEntity advertisementEntity) {
        return new Advertisement(
            advertisementEntity.getId(),
            advertisementEntity.getTitle(),
            advertisementEntity.getVideoUrl(),
            advertisementEntity.getAdvertiser(),
            advertisementEntity.getAgency(),
            advertisementEntity.getManufacturer(),
            advertisementEntity.getIsArchived()
        );
    }
}
