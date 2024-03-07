package com.kobaco.kobaco_project.domain.trend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class TrendAnalysis {
    private List<Tag> tagList;
    private List<Content> contentList;
    private Integer numberOfContent;
}
