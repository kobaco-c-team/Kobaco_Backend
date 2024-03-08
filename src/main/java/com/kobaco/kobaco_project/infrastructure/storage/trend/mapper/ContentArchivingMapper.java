package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.trend.model.ContentArchiving;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.ContentArchivingEntity;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component

public class ContentArchivingMapper {
    public ContentArchiving toDomain(ContentArchivingEntity contentArchiving){
        return ContentArchiving.of(
                contentArchiving.getPostType().getDescription(),
                contentArchiving.getImageUrl(),
                contentArchiving.getTitle(),
                contentArchiving.getContent()
        );
    }
}
