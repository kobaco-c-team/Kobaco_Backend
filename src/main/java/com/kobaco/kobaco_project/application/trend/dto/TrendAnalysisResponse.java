package com.kobaco.kobaco_project.application.trend.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record TrendAnalysisResponse(
        List<TagInfoResponse> tagInfoResponseList,
        List<ContentInfoResponse> contentInfoResponseList,
        Integer numberOfContent
) {
    public static TrendAnalysisResponse of(List<TagInfoResponse> tagInfoResponseList, List<ContentInfoResponse> contentInfoResponseList, Integer numberOfContent){
        return new TrendAnalysisResponse(tagInfoResponseList, contentInfoResponseList, numberOfContent);
    }


}
