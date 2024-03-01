package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.AdvertisementRepository;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadAdvertisement {

    private final AdvertisementRepository advertisementRepository;

    public Advertisement readAdvertisement(Long advertisementId) {
        return advertisementRepository.findById(advertisementId);
    }


}
