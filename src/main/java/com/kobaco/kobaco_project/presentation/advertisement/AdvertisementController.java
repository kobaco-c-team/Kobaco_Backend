package com.kobaco.kobaco_project.presentation.advertisement;

import com.kobaco.kobaco_project.application.advertisement.AdvertisementApplication;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementAiAnalysisResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementExpressionResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementAnalysisResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementInfoResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementListResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementSimilarListResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.ArchiveAdvertisementListResponse;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import io.swagger.v3.oas.annotations.Operation;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementApplication advertisementApplication;

    @Operation(summary = "광고 기본 정보 조회")
    @GetMapping("/info/{advertisementId}")
    public AdvertisementInfoResponse getAdvertisementInfo(@PathVariable Long advertisementId) {
        AdvertisementInfoResponse advertisementInfo = advertisementApplication.getAdvertisementInfo(advertisementId);
        return advertisementInfo;
    }

    @Operation(summary = "광고 표정 분석 조회")
    @GetMapping("/expression/{advertisementId}")
    public AdvertisementExpressionResponse getAdvertisementExpression(@PathVariable Long advertisementId) {
        AdvertisementExpressionResponse advertisementExpression = this.advertisementApplication.getAdvertisementExpression(advertisementId);
        return advertisementExpression;
    }

    @Operation(summary = "광고 영상 분석 결과 조회(영상 분위기, 인물, 사물)")
    @GetMapping("/analysis/{advertisementId}")
    public AdvertisementAnalysisResponse getAdvertisementAnalysis(@PathVariable Long advertisementId) {
        AdvertisementAnalysisResponse advertisementAnalysis = advertisementApplication.getAdvertisementAnalysis(advertisementId);
        return advertisementAnalysis;
    }

    @Operation(summary = "비슷한 분위기 광고 조회")
    @GetMapping("/similar/{advertisementId}")
    public AdvertisementSimilarListResponse getAdvertisementSimilar(@PathVariable Long advertisementId) {
        AdvertisementSimilarListResponse advertisementSimilarListResponse = advertisementApplication.getAdvertisementSimilarList(advertisementId);
        return advertisementSimilarListResponse;
    }

    @Operation(summary = "광고 스크랩")
    @PatchMapping("/archive/{advertisementId}")
    public void archiveAdvertisement(@PathVariable Long advertisementId) {
        advertisementApplication.archiveAdvertisement(advertisementId);
    }

    @Operation(summary = "영상 분석 결과 조회(이미지만 조회), category는 {person, object, place} 만 가능")
    @GetMapping("/ai-analysis/{advertisementId}/{category}")
    public AdvertisementAiAnalysisResponse getAiAnalysis(@PathVariable Long advertisementId, @PathVariable String category){
        return advertisementApplication.getAiAnalysis(advertisementId, category);
    }

    @Operation(summary = "광고 리스트 조회 & 검색 sortType \n"
            + "최신순은 LATEST, 관련도순은 RELATION, kwdVal은 검색어, startDate는 시작일, endDate는 종료일, "
            + "kwdVal이 없으면 빈 문자열을 넣어주세요, startDate와 endDate는 yyyy-MM-dd 형식으로 넣어주세요.\n"
            + "기본 정렬이 최신순이라 default는 LATEST로 설정해주세요.")
    @GetMapping("/list")
    public AdvertisementListResponse getAdvertisementList(
            @RequestParam(value = "sortType") String sortType,
            @RequestParam(value = "kwdVal", required = false) String kwdVal,
            @RequestParam(value = "startDate") LocalDate startDate,
            @RequestParam(value = "endDate") LocalDate endDate
    ) {
        AdvertisementListResponse advertisementListResponse = advertisementApplication.getAdvertisementList(sortType, kwdVal, startDate, endDate);
        return advertisementListResponse;
    }

    @Operation(summary = "광고 스크랩 리스트 조회 \n"
            + "kwdVal은 검색어, expressionType은 표정, moodVal은 분위기, kwdVal이 없으면 빈 문자열을 넣어주세요, expressionType이 없으면 null을 넣어주세요, moodVal이 없으면 빈 문자열을 넣어주세요."
            + "expressionType은 {SMILLING, SAD, SURPRISED, EXPRESSIONLESS, ANGRY, FROWN, SCARED} 중 하나를 넣어주세요.")
    @GetMapping("/archive")
    public ArchiveAdvertisementListResponse getArchiveList(
            @RequestParam(value = "kwdVal", required = false) String kwdVal,
            @RequestParam(value = "expressionType", required = false) ExpressionType expressionType,
            @RequestParam(value = "moodVal", required = false) String moodVal
    ) {
        ArchiveAdvertisementListResponse archiveAdvertisementListResponse = advertisementApplication.getArchiveList(kwdVal, expressionType, moodVal);
        return archiveAdvertisementListResponse;
    }

}
