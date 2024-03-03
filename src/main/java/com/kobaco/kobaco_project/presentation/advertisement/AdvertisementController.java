package com.kobaco.kobaco_project.presentation.advertisement;

import com.kobaco.kobaco_project.application.advertisement.AdvertisementApplication;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementExpressionResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementAnalysisResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementInfoResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementApplication advertisementApplication;

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

    @GetMapping("/analysis/{advertisementId}")
    public AdvertisementAnalysisResponse getAdvertisementAnalysis(@PathVariable Long advertisementId) {
        AdvertisementAnalysisResponse advertisementAnalysis = advertisementApplication.getAdvertisementAnalysis(advertisementId);
        return advertisementAnalysis;
    }

    @GetMapping("/similar/{advertisementId}")
    public AdvertisementSimilarResponse getAdvertisementSimilar(@PathVariable Long advertisementId){
        AdvertisementSimilarResponse advertisementSimilarResponse = advertisementApplication.getAdvertisementSimilar(advertisementId);
        return advertisementSimilarResponse;
    }
}
