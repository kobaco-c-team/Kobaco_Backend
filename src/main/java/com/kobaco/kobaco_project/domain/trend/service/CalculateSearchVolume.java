package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.SearchVolume;
import com.kobaco.kobaco_project.domain.trend.query.SearchVolumeRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class CalculateSearchVolume {
    private final SearchVolumeRepository searchVolumeRepository;
    private static final String MONTH_MAP = "monthStatisticMap";
    private static final String DAY_OF_WEEK_MAP = "dayOfWeekStatisticMap";

    public Map<String, Object> getTimeStatistic(final Long trendId) {
        List<SearchVolume> searchVolumes = searchVolumeRepository.findAllByTrendId(trendId);
        double totalSearchVolume = searchVolumes.stream()
                .mapToDouble(SearchVolume::getVolume)
                .sum();
        Map<String, Long> monthStatisticMap = searchVolumes.stream()
                .collect(
                        Collectors.groupingBy(
                                searchVolume -> searchVolume.getSearchDate().getMonth().name(),
                                LinkedHashMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.summingLong(SearchVolume::getVolume),
                                        sum -> (long) (sum / totalSearchVolume * 100)
                                )
                        )
                );
        Map<String, Long> dayOfWeekStatisticMap = searchVolumes.stream()
                .collect(
                        Collectors.groupingBy(
                                searchVolume -> searchVolume.getSearchDate().getDayOfWeek().name(),
                                LinkedHashMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.summingLong(SearchVolume::getVolume),
                                        sum -> (long) (sum / totalSearchVolume * 100)
                                )
                        )
                );
        return Map.of(MONTH_MAP, monthStatisticMap, DAY_OF_WEEK_MAP, dayOfWeekStatisticMap);
    }
}
