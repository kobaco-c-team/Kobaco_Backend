package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import com.kobaco.kobaco_project.domain.advertisement.query.MoodRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.MoodMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.MoodEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MoodRepositoryImpl implements MoodRepository {

    private final MoodEntityRepository moodEntityRepository;
    private final MoodMapper moodMapper;

    @Override
    public List<Mood> findAllByAdvertisementId(Long advertisementId) {
        return moodEntityRepository.findAllByAdvertisementEntityId(advertisementId)
                .stream()
                .map(moodMapper::toDomain)
                .toList();
    }

    @Override
    public List<Mood> findMoodByAdvertisementIds(List<Long> advertisementIds) {
        return moodEntityRepository.findAllByAdvertisementIds(advertisementIds)
                .stream()
                .map(moodMapper::toDomain)
                .toList();
    }

}
