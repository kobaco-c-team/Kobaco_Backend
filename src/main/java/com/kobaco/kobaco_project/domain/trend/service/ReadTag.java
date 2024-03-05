package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.domain.trend.query.TagRepository;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadTag {
    private final TagRepository tagRepository;
    public List<Tag> readTag(String kwdVal, String platform) {
        return this.tagRepository.findAllByKeywordNameAndPlatform(kwdVal,platform);
    }
}
