package com.kobaco.kobaco_project.infrastructure.storage.advertisement;

import com.kobaco.kobaco_project.domain.advertisement.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.AdvertisementRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.AdvertisementMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.AdvertisementEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AdvertisementRepositoryImpl implements AdvertisementRepository {

    private final AdvertisementEntityRepository advertisementEntityRepository;
    private final AdvertisementMapper advertisementMapper;
    @Override
    public Advertisement findById(Long id) {
        final AdvertisementEntity advertisementEntity = advertisementEntityRepository.findAdvertisementEntityById(id)
            .orElseThrow(() -> new RuntimeException("advertisement not found"));
        return advertisementMapper.toDomain(advertisementEntity);
    }
}
