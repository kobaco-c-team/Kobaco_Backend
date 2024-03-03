package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import com.kobaco.kobaco_project.domain.advertisement.model.Place;
import com.kobaco.kobaco_project.domain.advertisement.query.ItemRepository;
import com.kobaco.kobaco_project.domain.advertisement.query.PlaceRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadPlace {
    private final PlaceRepository placeRepository;

    public List<Place> getPlace(Long advertisementId) {
        return placeRepository.findAllByAdvertisementId(advertisementId);
    }
}
