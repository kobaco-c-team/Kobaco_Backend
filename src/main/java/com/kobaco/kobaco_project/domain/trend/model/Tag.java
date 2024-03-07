package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Tag {
    private String name;
    private Integer count;

    public static Tag of(String name, Integer count) {
        return new Tag(name, count);
    }
}
