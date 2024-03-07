package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.ContentArchiving;

import java.util.List;

public interface ContentArchivingRepository {
    List<ContentArchiving> findAllByKeyword(String trendKwd);
}
