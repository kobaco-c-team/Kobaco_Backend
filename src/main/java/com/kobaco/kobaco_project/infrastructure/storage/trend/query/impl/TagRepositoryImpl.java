package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.domain.trend.query.TagRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.TagMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.TagEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@RequiredArgsConstructor
public class TagRepositoryImpl implements TagRepository {
    private final TagEntityRepository tagEntityRepository;
    private final TagMapper tagMapper;
    @Override
    public List<Tag> findAllByKeywordNameAndPlatform(String kwdVal, String platform) {
        return tagEntityRepository.findAllByTrendEntityTrendKeywordAndPlatform(kwdVal, platform)
                .stream()
                .map(tagMapper::toDomain)
                .toList();
    }

    @Override
    public List<Tag> findAllByContentIdAndPlatform(Long id, String platform) {
        return tagEntityRepository.findAllByContentEntityIdAndPlatform(id, platform)
                .stream()
                .map(tagMapper::toDomain)
                .toList();
    }
}
