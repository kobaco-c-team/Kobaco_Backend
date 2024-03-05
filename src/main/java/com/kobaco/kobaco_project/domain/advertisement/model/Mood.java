package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Mood {
    private Long id;
    private String type;
    private Long advertisementId;

    public static Mood of(Long id, String type, Long advertisementId) {
        return new Mood(id, type, advertisementId);
    }
}
