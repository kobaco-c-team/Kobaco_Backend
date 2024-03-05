package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.ContentInfoResponse;
import com.kobaco.kobaco_project.application.trend.dto.TagInfoResponse;
import com.kobaco.kobaco_project.application.trend.dto.TrendAnalysisResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.trend.service.ReadContent;
import com.kobaco.kobaco_project.domain.trend.service.ReadInstaTrendAnalysis;
import com.kobaco.kobaco_project.domain.trend.service.ReadTag;
import com.kobaco.kobaco_project.domain.trend.service.ReadYoutubeTrendAnalysis;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {

    private final ReadTag readTag;
    private final ReadContent readContent;
    private final ReadInstaTrendAnalysis readInstaTrendAnalysis;
    private final ReadYoutubeTrendAnalysis readYoutubeTrendAnalysis;
    @Transactional
    public TrendAnalysisResponse getTrendAnalysis(String kwdVal, String snsType) {
        if(snsType.equals("INSTAGRAM")) this.readContent.setReadPlatformTrendAnalysis(readInstaTrendAnalysis);
        else if(snsType.equals("YOUTUBE")) this.readContent.setReadPlatformTrendAnalysis(readYoutubeTrendAnalysis);

        List<ContentInfoResponse> contentInfoResponseList = readContent.readContent(kwdVal).stream()
                .map(ContentInfoResponse::from)
                .toList();

        return TrendAnalysisResponse.builder()
                .tagInfoResponseList(
                        readTag.readTag(kwdVal).stream()
                                .map(TagInfoResponse::from)
                                .toList()
                )
                .contentInfoResponseList(
                        contentInfoResponseList
                )
                .numberOfContent(contentInfoResponseList.size())
                .build();
    }
}
