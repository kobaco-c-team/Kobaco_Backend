package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import java.time.LocalDate;

public record AdvertisementSimpleResponse(Long advertisementId, String title, String videoUrl,
                                          LocalDate createdAt, boolean isArchived, Long time) {

    public static AdvertisementSimpleResponse from(Advertisement advertisement, Long advertisementTime) {
        return new AdvertisementSimpleResponse(advertisement.getId(), advertisement.getTitle(), advertisement.getVideoUrl(),
                advertisement.getCreatedAt().toLocalDate(), advertisement.getIsArchived(), advertisementTime);
    }
}
