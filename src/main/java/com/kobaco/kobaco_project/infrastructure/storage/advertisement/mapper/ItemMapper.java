package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {
    public Item toDomain(final ItemEntity itemEntity) {
        return Item.of(
            itemEntity.getId(),
            itemEntity.getName()
        );
    }
}
