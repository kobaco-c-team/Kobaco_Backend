package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class Content {
    private String imageUrl;
    private String title;
    private List<String> tags;
    private Integer like;
    private String publisher;
}
