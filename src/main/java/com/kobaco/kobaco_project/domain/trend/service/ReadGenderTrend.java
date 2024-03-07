package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.domain.trend.query.GenderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadGenderTrend {
    private final GenderRepository genderRepository;

    public List<Gender> getGendersTrend(Long trendId) {
        return genderRepository.findAllByTrendId(trendId);
    }
}
