package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.TrendAnalysis;
import com.kobaco.kobaco_project.domain.trend.query.ContentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadYoutubeTrendAnalysis implements ReadPlatformTrendAnalysis{
    private final ContentRepository contentRepository;
    @Override
    public List<Content> getTrendAnalysis(String kwdVal) {
        List<Content> contentList = this.contentRepository.findBykeywordId(kwdVal);
        for(Content content : contentList) {
            content.setLike(null);
            content.setTags(null);
        }
        return contentList;
    }
}
