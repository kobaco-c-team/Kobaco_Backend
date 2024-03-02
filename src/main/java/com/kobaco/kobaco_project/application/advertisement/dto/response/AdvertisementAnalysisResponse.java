package com.kobaco.kobaco_project.application.advertisement.dto.response;

import java.util.List;

public record AdvertisementAnalysisResponse(
    List<MoodInfoResponse> moodInfo,
    List<ItemInfoResponse> objectInfo,
    List<PersonInfoResponse> personInfo
) {
    public static AdvertisementAnalysisResponse of(final List<MoodInfoResponse> moodInfo, final List<ItemInfoResponse> objectInfo, final List<PersonInfoResponse> personInfo) {
        return new AdvertisementAnalysisResponse(moodInfo, objectInfo, personInfo);
    }
}
