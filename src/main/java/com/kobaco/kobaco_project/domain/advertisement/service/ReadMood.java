package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import com.kobaco.kobaco_project.domain.advertisement.query.MoodRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadMood {
    private final MoodRepository moodRepository;

    public List<Mood> getMood(Long advertisementId) {
        return moodRepository.findAllByAdvertisementId(advertisementId);
    }
}
