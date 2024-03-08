package com.kobaco.kobaco_project.application.trend;

import com.kobaco.kobaco_project.application.trend.dto.*;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.trend.model.Tag;
import com.kobaco.kobaco_project.domain.trend.service.ReadContentArchiving;
import com.kobaco.kobaco_project.domain.trend.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import com.kobaco.kobaco_project.application.trend.dto.response.AgeStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.DayOfWeekStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.TimeStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.GenderStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.MonthStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.PersonStatisticResponse;
import com.kobaco.kobaco_project.domain.trend.model.Age;
import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.domain.trend.model.Trend;
import com.kobaco.kobaco_project.domain.trend.service.CalculateSearchVolume;
import com.kobaco.kobaco_project.domain.trend.service.ReadAgeTrend;
import com.kobaco.kobaco_project.domain.trend.service.ReadGenderTrend;
import com.kobaco.kobaco_project.domain.trend.service.ReadTrend;
import java.util.Map;
import java.util.stream.Collectors;

@ApplicationService
@RequiredArgsConstructor
public class TrendApplication {
    private final ReadTag readTag;
    private final List<ReadPlatformTrendAnalysis> readPlatformTrendAnalysis; //이렇게 interface의 List 형태로 bean을 주입 받으면 interface의 구현체들이 List 안에 담기게 된다.
    private final ReadTrend readTrend;
    private final ReadAgeTrend readAgeTrend;
    private final ReadGenderTrend readGenderTrend;
    private final CalculateSearchVolume caculateSearchVolume;
    private final ReadContentArchiving readContentArchiving;
    @Transactional(readOnly = true)
    public TrendAnalysisResponse getTrendAnalysis(String kwdVal, String snsType) {

        List<ContentInfoResponse> contentInfoResponseList = getContentFromDomain(kwdVal, snsType);

        return TrendAnalysisResponse.builder()
                .tagInfoResponseList(
                        readTag.readTag(kwdVal, snsType).stream()
                                .map(Tag::getName)
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


    @Transactional(readOnly = true)
    public PersonStatisticResponse getPersonStatistic(String trendKwd) {
        Trend trend = readTrend.getTrend(trendKwd);
        List<Age> ages = readAgeTrend.getAgesTrend(trend.getId());
        List<Gender> genders = readGenderTrend.getGendersTrend(trend.getId());
        return PersonStatisticResponse.of(
            ages.stream()
                .map(AgeStatisticResponse::of)
                .collect(Collectors.toList()),
            genders.stream()
                .map(GenderStatisticResponse::of)
                .collect(Collectors.toList())

        );
    }

    @Transactional(readOnly = true)
    public TimeStatisticResponse getTimeStatistic(String trendKwd) {
        Trend trend = readTrend.getTrend(trendKwd);
        Map<String, Object> timeStatisticMap = caculateSearchVolume.getTimeStatistic(trend.getId());
        Map<String, Long> monthStatisticMap = (Map<String, Long>) timeStatisticMap.get("monthStatisticMap");
        Map<String, Long> dayOfWeekStatisticMap = (Map<String, Long>) timeStatisticMap.get("dayOfWeekStatisticMap");

        return TimeStatisticResponse.of(
                monthStatisticMap.entrySet().stream()
                        .map(e -> MonthStatisticResponse.of(e.getKey(), e.getValue()))
                        .collect(Collectors.toList()),
                dayOfWeekStatisticMap.entrySet().stream()
                        .map(e -> DayOfWeekStatisticResponse.of(e.getKey(), e.getValue()))
                        .collect(Collectors.toList())
        );
    }

    public ContentArchivingListResponse getContentArchiving(String trendKwd, String order) {
        return ContentArchivingListResponse.of(
                readContentArchiving.readContentArchiving(trendKwd,order)
                .stream()
                .map(ContentArchivingResponse::from)
                .toList()
        );
    }
}

