package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.model.Mood;

import java.util.List;

public interface AdvertisementRepository {
    Advertisement findById(Long id);
    List<Advertisement> findAllByMoodList(List<Mood> moodList, Long advertisementId);
    void updateArchivedStatus(Advertisement advertisement);
}
