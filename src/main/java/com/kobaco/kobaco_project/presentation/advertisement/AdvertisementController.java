package com.kobaco.kobaco_project.presentation.advertisement;

import com.kobaco.kobaco_project.application.advertisement.AdvertisementApplication;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementExpressionResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementAnalysisResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementInfoResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementSimilarListResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
