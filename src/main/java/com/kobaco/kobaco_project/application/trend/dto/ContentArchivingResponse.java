package com.kobaco.kobaco_project.application.trend.dto;

import lombok.Builder;

@Builder
public record ContentArchivingResponse (
    String postType,
    String imageUrl,
    String title,
    String content

){
    public static ContentArchivingResponse from(ContentArchiving contentArchiving){
        return ContentArchivingResponse.builder()
                .postType(contentArchiving.getPostType())
                .imageUrl(contentArchiving.getImageUrl())
                .title(contentArchiving.getTitle())
                .content(contentArchiving.getContent())
                .build();
    }

}
