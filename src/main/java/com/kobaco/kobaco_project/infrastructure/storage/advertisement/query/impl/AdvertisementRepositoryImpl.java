package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import com.kobaco.kobaco_project.domain.advertisement.query.AdvertisementRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.AdvertisementMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.AdvertisementEntityRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.MoodEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AdvertisementRepositoryImpl implements AdvertisementRepository {

    private final AdvertisementEntityRepository advertisementEntityRepository;
    private final AdvertisementMapper advertisementMapper;
    private final MoodEntityRepository moodEntityRepository;

    @Override
    public Advertisement findById(Long id) {
        final AdvertisementEntity advertisementEntity = advertisementEntityRepository.findAdvertisementEntityById(id)
            .orElseThrow(() -> new RuntimeException("advertisement not found"));
        return advertisementMapper.toDomain(advertisementEntity);
    }

    @Override
    public List<Advertisement> findAllByMoodList(List<Mood> moodList, Long advertisementId) {
        List<Long> advertisementEntityIdList = new ArrayList<>();

        moodList.forEach(mood ->
                this.moodEntityRepository.findAllByType(mood.getType())
                        .stream()
                        .forEach(foundMood -> advertisementEntityIdList.add(foundMood.getAdvertisementEntity().getId()))
        );

        //빈도수 계산해서 map에 저장해두기
        Map<Long, Long> frequencyMap = advertisementEntityIdList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 빈도수에 따른 Comparator 정의
        Comparator<Long> frequencyComparator = (item1, item2) -> {
            long freq1 = frequencyMap.getOrDefault(item1, 0L);
            long freq2 = frequencyMap.getOrDefault(item2, 0L);
            return Long.compare(freq2, freq1); // 내림차순으로 빈도수 비교
        };

        // 중복을 제거하고 정렬된 리스트 생성
        return advertisementEntityIdList.stream()
                .sorted(frequencyComparator.thenComparing(Comparator.naturalOrder()))
                .distinct()
                .filter(id -> !id.equals(advertisementId))
                .map(id -> {
                    return advertisementMapper.toDomain(this.advertisementEntityRepository.findAdvertisementEntityById(id).orElseThrow(() -> new RuntimeException("advertisement not found")));
                })
                .toList();

    }

}
