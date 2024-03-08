package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class AdvertisementSimilar {
    private String videoUrl;
    private String title;
    private LocalDate createdAt;
    private List<Mood> moodList;
    private boolean isArchived;

    public static AdvertisementSimilar of(String videoUrl, String title, LocalDate createdAt, List<Mood> moodList, boolean isArchived){
        return new AdvertisementSimilar(videoUrl, title, createdAt, moodList, isArchived);
    }
}
