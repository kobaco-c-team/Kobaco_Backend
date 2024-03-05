package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.TrendAnalysis;

import java.util.List;

public interface ReadPlatformTrendAnalysis {
    public List<Content> getTrendAnalysis(String kwdVal);
}
