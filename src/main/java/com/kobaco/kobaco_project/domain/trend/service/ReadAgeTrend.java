package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.domain.trend.query.AgeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadAgeTrend {
    private final AgeRepository ageRepository;

    public List<Age> getAgesTrend(Long trendId) {
        return ageRepository.findAllByTrendId(trendId);
    }
}
