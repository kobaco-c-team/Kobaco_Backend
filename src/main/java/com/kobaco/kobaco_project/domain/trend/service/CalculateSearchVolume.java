package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.SearchVolume;
import com.kobaco.kobaco_project.domain.trend.query.SearchVolumeRepository;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class CalculateSearchVolume {
    private final SearchVolumeRepository searchVolumeRepository;
    private static final String MONTH_MAP = "monthStatisticMap";
    private static final String DAY_OF_WEEK_MAP = "dayOfWeekStatisticMap";
    List<String> dayOfWeekOrder = Arrays.asList("월", "화", "수", "목", "금", "토", "일");

    public Map<String, Object> getTimeStatistic(final Long trendId) {
        List<SearchVolume> searchVolumes = searchVolumeRepository.findAllByTrendId(trendId);
        double totalSearchVolume = searchVolumes.stream()
                .mapToDouble(SearchVolume::getVolume)
                .sum();

        Map<String, Long> monthStatisticMap = calculateMonthStatistic(searchVolumes, totalSearchVolume);
        Map<String, Long> dayOfWeekStatisticMap = calculateDayOfWeekStatistic(searchVolumes, totalSearchVolume);

        return Map.of(MONTH_MAP, monthStatisticMap, DAY_OF_WEEK_MAP, dayOfWeekStatisticMap);
    }

    private Map<String, Long> calculateMonthStatistic(List<SearchVolume> searchVolumes, double totalSearchVolume) {
        return searchVolumes.stream()
                .collect(
                        Collectors.groupingBy(
                                searchVolume -> searchVolume.getSearchDate().getMonth().getDisplayName(TextStyle.FULL, Locale.KOREAN),
                                LinkedHashMap::new,
                                Collectors.collectingAndThen(
                                        Collectors.summingLong(SearchVolume::getVolume),
                                        sum -> (long) (sum / totalSearchVolume * 100)
                                )
                        )
                );
    }

    private Map<String, Long> calculateDayOfWeekStatistic(List<SearchVolume> searchVolumes, double totalSearchVolume) {
        Map<String, Long> dayOfWeekStatisticMap = searchVolumes.stream()
                .collect(
                        Collectors.groupingBy(
                                searchVolume -> {
                                    String dayOfWeek = searchVolume.getSearchDate().getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN);
                                    return dayOfWeek.replace("요일", "");
                                },
                                Collectors.collectingAndThen(
                                        Collectors.summingLong(SearchVolume::getVolume),
                                        sum -> (long) (sum / totalSearchVolume * 100)
                                )
                        )
                );

        Map<String, Long> sortedDayOfWeekStatisticMap = new LinkedHashMap<>();
        dayOfWeekOrder.forEach(day -> {
            sortedDayOfWeekStatisticMap.put(day, dayOfWeekStatisticMap.getOrDefault(day, 0L));
        });
        return sortedDayOfWeekStatisticMap;
    }

}
