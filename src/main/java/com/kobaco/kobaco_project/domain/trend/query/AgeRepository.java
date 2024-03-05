package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.Age;
import java.util.List;

public interface AgeRepository {
    List<Age> findAllByTrendId(Long trendId);
}
