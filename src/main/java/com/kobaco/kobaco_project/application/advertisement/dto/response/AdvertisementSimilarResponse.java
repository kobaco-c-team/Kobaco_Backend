package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.AdvertisementSimilar;
import lombok.Builder;

import java.util.List;

@Builder
public record AdvertisementSimilarResponse(String videoUrl, String title, String agency, List<MoodInfoResponse> moodInfo, boolean isArchived) {

    public static AdvertisementSimilarResponse from(AdvertisementSimilar advertisementSimilar){
        return AdvertisementSimilarResponse.builder()
                .videoUrl(advertisementSimilar.getVideoUrl())
                .title(advertisementSimilar.getTitle())
                .agency(advertisementSimilar.getAgency())
                .moodInfo(advertisementSimilar.getMoodList()
                        .stream()
                        .map(mood -> new MoodInfoResponse(mood.getType()))
                        .toList()
                )
                .isArchived(advertisementSimilar.isArchived())
                .build();
    }
}
