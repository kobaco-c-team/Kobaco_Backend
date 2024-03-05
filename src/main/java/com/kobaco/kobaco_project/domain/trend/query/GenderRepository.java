package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.Gender;
import java.util.List;

public interface GenderRepository {
    List<Gender> findAllByTrendId(Long trendId);
}
