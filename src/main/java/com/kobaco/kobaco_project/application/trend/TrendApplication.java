package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.TrendAnalysisResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {

    @Transactional
    public TrendAnalysisResponse getTrendAnalysis(String kwdVal, String snsType) {

    }
}
