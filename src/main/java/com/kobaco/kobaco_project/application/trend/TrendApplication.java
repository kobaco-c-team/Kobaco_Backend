package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.ContentInfoResponse;
import com.kobaco.kobaco_project.application.trend.dto.TagInfoResponse;
import com.kobaco.kobaco_project.application.trend.dto.TrendAnalysisResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.trend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {

    private final ReadTag readTag;
    private final List<ReadPlatformTrendAnalysis> readPlatformTrendAnalysis; //이렇게 interface의 List 형태로 bean을 주입 받으면 interface의 구현체들이 List 안에 담기게 된다.
    @Transactional(readOnly = true)
    public TrendAnalysisResponse getTrendAnalysis(String kwdVal, String snsType) {

        List<ContentInfoResponse> contentInfoResponseList = getContentFromDomain(kwdVal, snsType);

        return TrendAnalysisResponse.builder()
                .tagInfoResponseList(
                        readTag.readTag(kwdVal, snsType).stream()
                                .map(TagInfoResponse::from)
                                .toList()
                )
                .contentInfoResponseList(
                        contentInfoResponseList
                )
                .numberOfContent(contentInfoResponseList.size())
                .build();
    }

    private List<ContentInfoResponse> getContentFromDomain(String kwdVal, String snsType){
        for(ReadPlatformTrendAnalysis readPlatformTrendAnalysis1 : readPlatformTrendAnalysis) {
            if(readPlatformTrendAnalysis1.isSameType(snsType)){
                return readPlatformTrendAnalysis1.getTrendAnalysis(kwdVal)
                        .stream()
                        .map(ContentInfoResponse::from)
                        .toList();
            }
        }
        return null;
    }
}

