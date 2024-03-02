package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Advertisement {
    private Long id;
    private String title;
    private String videoUrl;
    private String advertiser;
    private String agency;
    private String manufacturer;
    private Boolean isArchived;

    public static Advertisement of(Long id, String title, String videoUrl, String advertiser, String agency, String manufacturer, Boolean isArchived) {
        return new Advertisement(id, title, videoUrl, advertiser, agency, manufacturer, isArchived);
    }

}
