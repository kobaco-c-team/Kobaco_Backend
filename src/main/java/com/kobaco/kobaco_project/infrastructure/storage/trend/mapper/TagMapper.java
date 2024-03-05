package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.TagEntity;
import org.springframework.stereotype.Component;

@Component
public class TagMapper {
    public Tag toDomain(final TagEntity tagEntity) {
        return Tag.of(
                tagEntity.getName(),
                tagEntity.getCount()
        );
    }
}
