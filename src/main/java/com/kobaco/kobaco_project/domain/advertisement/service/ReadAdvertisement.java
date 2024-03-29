package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.domain.advertisement.query.AdvertisementRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadAdvertisement {

    private final AdvertisementRepository advertisementRepository;
    private static final String SORT_BY_DATE = "LATEST";
    private static final String SORT_BY_RELATION = "RELATION";

    public Advertisement getAdvertisement(Long advertisementId) {
        return advertisementRepository.findById(advertisementId)
            .orElseThrow(() -> new IllegalArgumentException("해당 광고가 존재하지 않습니다."));
    }

    public List<Advertisement> getAdvertisementList(String sortType, String kwdVal,
                                                    LocalDateTime start, LocalDateTime end, List<ExpressionType> expressionTypeList, List<String> moodTypeList) {
        if (SORT_BY_DATE.equals(sortType)) {
            return advertisementRepository.findAllBySort(kwdVal, start, end, expressionTypeList, moodTypeList);
        } else if (SORT_BY_RELATION.equals(sortType)) {
            return advertisementRepository.findAllByRelation(kwdVal, start, end, expressionTypeList, moodTypeList);
        } else {
            throw new IllegalArgumentException("정렬 타입이 올바르지 않습니다.");
        }
    }

    public List<Advertisement> getArchiveList(String kwdVal, List<ExpressionType> expressionTypeList, List<String> moodTypeList) {
        return Optional.ofNullable(expressionTypeList)
                .map(et -> advertisementRepository.findAllByArchiveWithExpression(kwdVal, expressionTypeList, moodTypeList))
                .orElse(advertisementRepository.findAllByArchive(kwdVal, moodTypeList));
    }

}
