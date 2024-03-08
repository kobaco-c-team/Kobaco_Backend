package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContentArchiving {
    private String postType;
    private String imageUrl;
    private String title;
    private String content;

    public static ContentArchiving of(String postType, String imageUrl, String title, String content){
        return new ContentArchiving(postType, imageUrl, title, content);
    }
}
