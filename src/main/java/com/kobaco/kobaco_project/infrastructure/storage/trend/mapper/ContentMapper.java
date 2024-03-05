package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.ContentEntity;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.TagEntity;
import org.springframework.stereotype.Component;

@Component
public class ContentMapper {
    public Content toDomain(final ContentEntity contentEntity) {
        return Content.of(
                contentEntity.getId(),
                contentEntity.getImageUrl(),
                contentEntity.getTitle(),
                contentEntity.getLikes(),
                contentEntity.getPublisher()
        );
    }
}
