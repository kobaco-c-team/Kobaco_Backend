package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.Content;

import java.util.List;

public interface ContentRepository {
    List<Content> findByKeywordNameAndPlatform(String kwdVal, String platform);
}
