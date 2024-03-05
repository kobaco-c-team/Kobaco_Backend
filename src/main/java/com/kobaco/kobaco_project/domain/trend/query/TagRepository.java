package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.Tag;

import java.util.List;

public interface TagRepository {
    List<Tag> findAllKeywordId(String kwdVal);
}
