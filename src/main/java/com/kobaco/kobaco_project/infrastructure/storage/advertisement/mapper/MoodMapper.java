package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.MoodEntity;
import org.springframework.stereotype.Component;

@Component
public class MoodMapper {
    public Mood toDomain(final MoodEntity moodEntity) {
        return Mood.of(
            moodEntity.getId(),
            moodEntity.getType(),
            moodEntity.getAdvertisementEntity().getId()
        );
    }
}
