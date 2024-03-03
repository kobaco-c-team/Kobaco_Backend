package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Image {
    private Long id;
    private String type;
    private String imageUrl;
    public static Image of(Long id, String type, String imageUrl){
        return new Image(id, type, imageUrl);
    }
}
