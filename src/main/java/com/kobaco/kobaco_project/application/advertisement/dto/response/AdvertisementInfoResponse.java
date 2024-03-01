package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.Advertisement;

public record AdvertisementInfoResponse(String videoUrl, String advertiser, String agency, String manufacturer, boolean isArchived) {

    public static AdvertisementInfoResponse from(final Advertisement advertisement) {
        return new AdvertisementInfoResponse(advertisement.getVideoUrl(), advertisement.getAdvertiser(),
                advertisement.getAgency(), advertisement.getManufacturer(), advertisement.getIsArchived());
    }
}
