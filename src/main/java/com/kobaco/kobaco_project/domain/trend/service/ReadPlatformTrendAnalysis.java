package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.ContentWithTag;
import com.kobaco.kobaco_project.domain.trend.model.TrendAnalysis;

import java.util.List;

@DomainService
public interface ReadPlatformTrendAnalysis {
    public List<ContentWithTag> getTrendAnalysis(String kwdVal);
    public boolean isSameType(String snsType);

}
