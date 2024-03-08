package com.kobaco.kobaco_project.application.advertisement.dto.response;

import java.util.List;

public record AdvertisementAnalysisResponse(
    List<String> moodInfo,
    List<String> objectInfo,
    List<String> personInfo
) {
    public static AdvertisementAnalysisResponse of(final List<String> moodInfo, final List<String> objectInfo, final List<String> personInfo) {
        return new AdvertisementAnalysisResponse(moodInfo, objectInfo, personInfo);
    }
}
