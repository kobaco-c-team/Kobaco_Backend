package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Image;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.ImageEntity;
import org.springframework.stereotype.Component;

@Component
public class ImageMapper {
    public Image toDomain(final ImageEntity imageEntity) {
        return Image.of(
                imageEntity.getId(),
                imageEntity.getType(),
                imageEntity.getImageUrl()
        );
    }
}
