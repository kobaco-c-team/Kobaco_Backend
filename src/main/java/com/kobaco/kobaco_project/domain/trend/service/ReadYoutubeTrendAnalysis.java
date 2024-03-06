package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.ContentWithTag;
import com.kobaco.kobaco_project.domain.trend.model.TrendAnalysis;
import com.kobaco.kobaco_project.domain.trend.query.ContentRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadYoutubeTrendAnalysis implements ReadPlatformTrendAnalysis{
    private final ContentRepository contentRepository;
    @Override
    public List<ContentWithTag> getTrendAnalysis(String kwdVal) {
        List<Content> contentList = contentRepository.findByKeywordNameAndPlatform(kwdVal, "YOUTUBE");
        return contentList.stream()
                .map(content -> ContentWithTag.builder()
                        .imageUrl(content.getImageUrl())
                        .title(content.getTitle())
                        .tags(null)
                        .like(null)
                        .publisher(content.getPublisher())
                        .build()
                )
                .toList();
    }
}
