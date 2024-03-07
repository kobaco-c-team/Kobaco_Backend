package com.kobaco.kobaco_project.application.trend.dto;

import java.util.List;

public record ContentArchivingListResponse (List<ContentArchivingResponse> contentArchivingResponseList){
    public static ContentArchivingListResponse of(List<ContentArchivingResponse> contentArchivingResponseList){
        return new ContentArchivingListResponse(contentArchivingResponseList);
    }
}
