package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;

public interface AdvertisementRepository {
    Advertisement findById(Long id);
}
