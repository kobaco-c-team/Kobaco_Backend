package com.kobaco.kobaco_project.application.advertisement;

import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementAnalysisResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.AdvertisementInfoResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.MoodInfoResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.ItemInfoResponse;
import com.kobaco.kobaco_project.application.advertisement.dto.response.PersonInfoResponse;
import com.kobaco.kobaco_project.common.annotation.ApplicationService;
import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.service.ArchiveAdvertisement;
import com.kobaco.kobaco_project.domain.advertisement.service.ReadAdvertisement;
import com.kobaco.kobaco_project.domain.advertisement.service.ReadMood;
import com.kobaco.kobaco_project.domain.advertisement.service.ReadItem;
import com.kobaco.kobaco_project.domain.advertisement.service.ReadPerson;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationService
@RequiredArgsConstructor
public class AdvertisementApplication {
    private final ReadAdvertisement readAdvertisement;
    private final ReadMood readMood;
    private final ReadItem readItem;
    private final ReadPerson readPerson;
    private final ArchiveAdvertisement archiveAdvertisement;

    @Transactional(readOnly = true)
    public AdvertisementInfoResponse getAdvertisementInfo(Long advertisementId) {
        final Advertisement advertisement = readAdvertisement.getAdvertisement(advertisementId);
        return AdvertisementInfoResponse.from(advertisement);
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

    @Transactional
    public void archiveAdvertisement(Long advertisementId) {
        archiveAdvertisement.archiveAdvertisement(advertisementId);
    }

}
