package com.kobaco.kobaco_project.domain.trend.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ContentWithTag {
    private String imageUrl;
    private String title;
    private List<String> tags;
    private Integer like;
    private String publisher;

    public static ContentWithTag from(Content content, List<Tag> tags){
        return ContentWithTag.builder()
                .imageUrl(content.getImageUrl())
                .title(content.getTitle())
                .tags(tags.stream().map(Tag::getName).toList())
                .like(content.getLike())
                .publisher(content.getPublisher())
                .build();
    }
}
