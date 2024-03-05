package com.kobaco.kobaco_project.application.trend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kobaco.kobaco_project.domain.trend.model.Content;
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
    public static ContentInfoResponse from(Content content){
        return ContentInfoResponse.builder()
                .imageUrl(content.getImageUrl())
                .title(content.getTitle())
                .tags(content.getTags())
                .like(content.getLike())
                .publisher(content.getPublisher())
                .build();
    }

}
