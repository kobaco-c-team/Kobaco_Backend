package com.kobaco.kobaco_project.application.advertisement.dto.response;

import java.util.List;

public record AdvertisementListResponse(List<AdvertisementSimpleResponse> advertisementSimpleResponses) {

    public static AdvertisementListResponse of(final List<AdvertisementSimpleResponse> advertisementSimpleResponses) {
        return new AdvertisementListResponse(advertisementSimpleResponses);
    }

}
