package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import java.time.LocalDate;

public record AdvertisementInfoResponse(String videoUrl, String title, LocalDate createdAt, String advertiser, String agency, String manufacturer, boolean isArchived) {

    public static AdvertisementInfoResponse from(final Advertisement advertisement) {
        return new AdvertisementInfoResponse(advertisement.getVideoUrl(), advertisement.getTitle(), advertisement.getCreatedAt().toLocalDate(), advertisement.getAdvertiser(),
                advertisement.getAgency(), advertisement.getManufacturer(), advertisement.getIsArchived());
    }
}
