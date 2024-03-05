package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.Trend;
import java.util.Optional;

public interface TrendRepository {
    Optional<Trend> findByTrendKeyword(String trendKwd);
}
