package com.kobaco.kobaco_project.application.advertisement.dto.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

public record AdvertisementAiAnalysisResponse (
        String category,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<PersonInfoResponse> personInfo,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<ItemInfoResponse> itemInfo,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<PlaceInfoResponse> placeInfo,
        List<String> imageUrls
){
    public static AdvertisementAiAnalysisResponse of(String category, List<PersonInfoResponse> personInfo, List<ItemInfoResponse> itemInfo,List<PlaceInfoResponse> placeInfo,List<String> imageUrls){
        return new AdvertisementAiAnalysisResponse(category, personInfo, itemInfo, placeInfo, imageUrls);
    }

}
