package com.kobaco.kobaco_project.application.advertisement.dto.response;


import java.util.List;

public record AdvertisementSimilarListResponse(
        List<AdvertisementSimilarResponse> advertisementSimilarResponseList
) {
    public static AdvertisementSimilarListResponse from(List<AdvertisementSimilarResponse> advertisementSimilarResponseList){
        return new AdvertisementSimilarListResponse(advertisementSimilarResponseList);
    }
}
