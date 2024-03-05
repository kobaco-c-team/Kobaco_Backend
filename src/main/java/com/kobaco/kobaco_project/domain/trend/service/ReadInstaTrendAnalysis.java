package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.TrendAnalysis;
import com.kobaco.kobaco_project.domain.trend.query.ContentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadInstaTrendAnalysis implements ReadPlatformTrendAnalysis{
    private final ContentRepository contentRepository;

    @Override
    public List<Content> getTrendAnalysis(String kwdVal) {
        List<Content> contentList = this.contentRepository.findBykeywordId(kwdVal);
        for(Content content : contentList) content.setPublisher(null);
        return contentList;
    }
}
