package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import com.kobaco.kobaco_project.domain.advertisement.query.MoodRepository;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadMood {
    private final MoodRepository moodRepository;

    public List<Mood> getMood(Long advertisementId) {
        return moodRepository.findAllByAdvertisementId(advertisementId);
    }

    public Map<Long, List<Mood>> getMoodByAdvertisementIds(List<Long> advertisementIds) {
        List<Mood> moods = moodRepository.findMoodByAdvertisementIds(advertisementIds);
        return Optional.ofNullable(moods)
                .orElse(Collections.emptyList())
                .stream()
                .collect(Collectors.groupingBy(Mood::getAdvertisementId));
    }
}
