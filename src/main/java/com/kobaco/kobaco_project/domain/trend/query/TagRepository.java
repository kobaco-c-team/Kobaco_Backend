package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> findAllByKeywordNameAndPlatform(String kwdVal, String platform);

    List<Tag> findAllByContentIdAndPlatform(Long id, String platform);
}
