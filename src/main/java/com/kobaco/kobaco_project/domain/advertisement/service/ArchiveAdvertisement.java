package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.query.AdvertisementRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ArchiveAdvertisement {

        private final AdvertisementRepository advertisementRepository;

        public void archiveAdvertisement(Long advertisementId) {
            Advertisement advertisement = advertisementRepository.findById(advertisementId);
            advertisement.archive();
            advertisementRepository.updateArchivedStatus(advertisement);
        }
}
