package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import com.kobaco.kobaco_project.domain.advertisement.model.Place;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ItemEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.PlaceEntity;
import org.springframework.stereotype.Component;

@Component
public class PlaceMapper {
    public Place toDomain(final PlaceEntity placeEntity) {
        return Place.of(
                placeEntity.getId(),
                placeEntity.getName()
        );
    }
}
