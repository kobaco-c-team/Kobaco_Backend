package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.ContentWithTag;
import com.kobaco.kobaco_project.domain.trend.model.PlatformType;
import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.domain.trend.query.ContentRepository;
import com.kobaco.kobaco_project.domain.trend.query.TagRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@Getter
@RequiredArgsConstructor
public class ReadInstaTrendAnalysis implements ReadPlatformTrendAnalysis{
    private final ContentRepository contentRepository;
    private final TagRepository tagRepository;

    @Override
    public List<ContentWithTag> getTrendAnalysis(String kwdVal) {
        List<Content> contentList = contentRepository.findByKeywordNameAndPlatform(kwdVal, PlatformType.INSTAGRAM.getDescription());
        return contentList.stream()
                .map(content -> ContentWithTag.builder()
                        .imageUrl(content.getImageUrl())
                        .title(content.getTitle())
                        .tags(tagRepository.findAllByContentIdAndPlatform(content.getId(), PlatformType.INSTAGRAM.getDescription()).stream().map(Tag::getName).toList())
                        .like(content.getLike())
                        .publisher(null)
                        .build()
                )
                .toList();
    }

    @Override
    public boolean isSameType(String snsType) {
        return snsType.equals(PlatformType.INSTAGRAM.getDescription());
    }
}
