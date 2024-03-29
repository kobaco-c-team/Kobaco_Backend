package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.model.AdvertisementSimilar;
import com.kobaco.kobaco_project.domain.advertisement.query.AdvertisementRepository;
import com.kobaco.kobaco_project.domain.advertisement.query.MoodRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadAdvertisementSimilar {

    private final MoodRepository moodRepository;
    private final AdvertisementRepository advertisementRepository;

    public List<AdvertisementSimilar> getAdvertisementSimilarList(Long advertisementId) {
        List<Advertisement> advertisementList = advertisementRepository.findAllByMoodList(moodRepository.findAllByAdvertisementId(advertisementId), advertisementId);

        List<AdvertisementSimilar> advertisementSimilarList = new ArrayList<>();
        advertisementList
                .forEach(advertisement -> advertisementSimilarList.add(AdvertisementSimilar.of(
                        advertisement.getVideoUrl(),
                        advertisement.getTitle(),
                        LocalDate.from(advertisement.getCreatedAt()),
                        moodRepository.findAllByAdvertisementId(advertisement.getId()),
                        advertisement.getIsArchived()
                )));

        return advertisementSimilarList;

    }
}
