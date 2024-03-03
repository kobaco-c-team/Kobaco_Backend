package com.kobaco.kobaco_project.application.advertisement;

import com.kobaco.kobaco_project.application.advertisement.dto.response.*;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;


@ApplicationService
@RequiredArgsConstructor
public class AdvertisementApplication {
    private final ReadAdvertisement readAdvertisement;
    private final ReadExpressionSection readAllExpressions;
    private final ReadOrderOfExpression readOrderOfExpression;
    private final ReadMood readMood;
    private final ReadItem readItem;
    private final ReadPerson readPerson;
    private final ReadAdvertisementSimilar readAdvertisementSimilar;

    @Transactional(readOnly = true)
    public AdvertisementInfoResponse getAdvertisementInfo(Long advertisementId) {
        final Advertisement advertisement = readAdvertisement.getAdvertisement(advertisementId);
        return AdvertisementInfoResponse.from(advertisement);
    }

    @Transactional(readOnly = true)
    public AdvertisementExpressionResponse getAdvertisementExpression(Long advertisementId) {
        return AdvertisementExpressionResponse.of(
                this.readAllExpressions.getExpressionSection(advertisementId)
                        .stream()
                        .map(ExpressionSectionResponse::of)
                        .toList()
                ,
                this.readOrderOfExpression.readFirstExpression(advertisementId),
                this.readOrderOfExpression.readSecondExpression(advertisementId)
        );
    }

    @Transactional(readOnly = true)
    public AdvertisementAnalysisResponse getAdvertisementAnalysis(Long advertisementId) {
        return AdvertisementAnalysisResponse.of(
                readMood.getMood(advertisementId)
                        .stream()
                        .map(mood -> MoodInfoResponse.of(mood.getType()))
                        .toList(),
                readItem.getItem(advertisementId)
                        .stream()
                        .map(item -> ItemInfoResponse.of(item.getName()))
                        .toList(),
                readPerson.getPerson(advertisementId)
                        .stream()
                        .map(person -> PersonInfoResponse.of(person.getName()))
                        .toList()
        );
    }

    @Transactional(readOnly = true)
    public AdvertisementSimilarListResponse getAdvertisementSimilarList(Long advertisementId){
        return AdvertisementSimilarListResponse.from(
                this.readAdvertisementSimilar.getAdvertisementSimilar(advertisementId)
                        .stream()
                        .map(advertisementSimilar -> AdvertisementSimilarResponse.from(advertisementSimilar))
                        .toList()
        );
    }

}
