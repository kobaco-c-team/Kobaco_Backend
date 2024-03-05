package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.ContentWithTag;
import com.kobaco.kobaco_project.domain.trend.model.TrendAnalysis;

import java.util.List;

public interface ReadPlatformTrendAnalysis {
    public List<ContentWithTag> getTrendAnalysis(String kwdVal);
}
