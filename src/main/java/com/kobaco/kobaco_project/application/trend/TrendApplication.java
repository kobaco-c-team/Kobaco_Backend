package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.ContentInfoResponse;
import com.kobaco.kobaco_project.application.trend.dto.TagInfoResponse;
import com.kobaco.kobaco_project.application.trend.dto.TrendAnalysisResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {

    private final ReadTrendAnalysis readTrendAnalysis;
    @Transactional
    public TrendAnalysisResponse getTrendAnalysis(String kwdVal, String snsType) {
        TrendAnalysis trendAnalysis = this.readTrendAnalysis.getTrendAnalysis(kwdVal,snsType);
        return TrendAnalysisResponse.builder()
                .tagInfoResponseList(
                        trendAnalysis.getTagInfo().stream()
                                .map(tag -> TagInfoResponse.from(tag))
                                .toList()
                )
                .contentInfoResponseList(
                        trendAnalysis.getContentInfo().stream()
                                .map(content -> ContentInfoResponse.from(content))
                                .toList()
                )
                .numberOfContent(trendAnalysis.gotNumberOfContent())
                .build();
    }
}
