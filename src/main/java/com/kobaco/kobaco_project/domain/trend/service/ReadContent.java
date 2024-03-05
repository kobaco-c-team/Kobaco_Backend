package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.Content;
import com.kobaco.kobaco_project.domain.trend.model.ContentWithTag;
import lombok.RequiredArgsConstructor;
import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadContent {
    private ReadPlatformTrendAnalysis readPlatformTrendAnalysis = null;


    public void setReadPlatformTrendAnalysis(ReadPlatformTrendAnalysis readPlatTrendAnalysis) {
        this.readPlatformTrendAnalysis = readPlatTrendAnalysis;
    }

    public List<ContentWithTag> readContent(String kwdVal) {
        return this.readPlatformTrendAnalysis.getTrendAnalysis(kwdVal);
    }
}
