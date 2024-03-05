package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Trend;
import com.kobaco.kobaco_project.domain.trend.query.TrendRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadTrend {
    private final TrendRepository trendRepository;

    public Trend getPersonTrend(String trendKwd) {
        return trendRepository.findByTrendKeyword(trendKwd)
                .orElseThrow(() -> new IllegalArgumentException("해당 트렌드가 존재하지 않습니다."));
    }
}
