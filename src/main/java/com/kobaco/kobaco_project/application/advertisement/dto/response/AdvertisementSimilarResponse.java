package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.AdvertisementSimilar;
import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record AdvertisementSimilarResponse(String videoUrl, String title, LocalDate createdAt, List<String> moodInfo, boolean isArchived) {

    public static AdvertisementSimilarResponse from(AdvertisementSimilar advertisementSimilar){
        return AdvertisementSimilarResponse.builder()
                .videoUrl(advertisementSimilar.getVideoUrl())
                .title(advertisementSimilar.getTitle())
                .createdAt(advertisementSimilar.getCreatedAt())
                .moodInfo(advertisementSimilar.getMoodList()
                        .stream()
                        .map(Mood::getType)
                        .toList()
                )
                .isArchived(advertisementSimilar.isArchived())
                .build();
    }
}
