package com.kobaco.kobaco_project.domain.trend.model;


import lombok.Getter;

@Getter
public enum PostType {
    BLOG("네이버 블로그"), NEWS("네이버 뉴스");

    private String description;

    PostType(String description){
        this.description = description;
    }
}
