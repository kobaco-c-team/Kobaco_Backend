package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import com.kobaco.kobaco_project.domain.advertisement.model.Place;

import java.util.List;

public interface PlaceRepository {
    List<Place> findAllByAdvertisementId(Long advertisementId);
}
