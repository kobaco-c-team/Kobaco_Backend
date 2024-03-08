package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.query.ContentRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.ContentMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.ContentEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContentRepositoryImpl implements ContentRepository {
    private final ContentEntityRepository contentEntityRepository;
    private final ContentMapper contentMapper;
    @Override
    public List<Content> findByKeywordNameAndPlatform(String kwdVal, String platform) {
        return contentEntityRepository.findByTrendEntityTrendKeywordAndPlatform(kwdVal, platform)
                .stream()
                .map(contentMapper::toDomain)
                .toList();
    }
}
