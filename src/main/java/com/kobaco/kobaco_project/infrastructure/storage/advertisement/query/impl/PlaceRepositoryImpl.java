package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Place;
import com.kobaco.kobaco_project.domain.advertisement.query.PlaceRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.PlaceMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.PlaceEntityRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaceRepositoryImpl implements PlaceRepository {
    private final PlaceEntityRepository placeEntityRepository;
    private final PlaceMapper placeMapper;

    @Override
    public List<Place> findAllByAdvertisementId(Long advertisementId) {
        return placeEntityRepository.findAllByAdvertisementEntityId(advertisementId)
                .stream()
                .map(placeMapper::toDomain)
                .toList();
    }
}
