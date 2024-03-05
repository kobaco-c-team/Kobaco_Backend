package com.kobaco.kobaco_project.domain.trend.model;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchVolume {
    private LocalDateTime searchDate;
    private Long volume;

    public static SearchVolume of(LocalDateTime searchDate, Long volume) {
        return new SearchVolume(searchDate, volume);
    }
}
