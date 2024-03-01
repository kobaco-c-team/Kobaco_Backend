package com.kobaco.kobaco_project.application.advertisement;

import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementExpressionResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementInfoResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.advertisement.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.service.ReadAdvertisement;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@ApplicationService
@RequiredArgsConstructor
public class AdvertisementApplication {
    private final ReadAdvertisement readAdvertisement;
    @Transactional(readOnly = true)
    public AdvertisementInfoResponse getAdvertisementInfo(Long advertisementId) {
        final Advertisement advertisement = readAdvertisement.readAdvertisement(advertisementId);
        return AdvertisementInfoResponse.from(advertisement);
    }

    @Transactional(readOnly = true)
    public AdvertisementExpressionResponse getAdvertisementExpression(Long advertisementId){
        final List<Expression> expressionList = readAllExpresssions.readAllExpressions(advertisementId);
        return AdvertisementExpressionResponse.from(expressionList);
    }

}
