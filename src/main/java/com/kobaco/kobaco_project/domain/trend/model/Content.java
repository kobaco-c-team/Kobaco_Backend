package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Content {
    private Long id;
    private String imageUrl;
    private String title;
    private Integer like;
    private String publisher;

    public static Content of(Long id, String imageUrl, String title, Integer like, String publisher){
        return new Content(id, imageUrl, title, like, publisher);
    }
}
