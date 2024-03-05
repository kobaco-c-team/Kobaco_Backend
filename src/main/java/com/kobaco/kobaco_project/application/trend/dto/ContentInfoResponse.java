package com.kobaco.kobaco_project.application.trend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@Builder
public record ContentInfoResponse(
        String imageUrl,
        String title,
        @JsonInclude(JsonInclude.Include.NON_NULL) List<String> tags,
        @JsonInclude(JsonInclude.Include.NON_NULL) Integer like,
        @JsonInclude(JsonInclude.Include.NON_NULL) String publisher
) {
    public static ContentInfoResponse from(ContentInfo contentInfo){
        return ContentInfoResponse.builder()
                .imageUrl(contentInfo.getImagUrl())
                .title(contentInfo.getTitle())
                .tags(contentInfo.getTags())
                .like(contentInfo.getLike())
                .publisher(contentInfo.getPublisher())
                .build();
    }

}
