package com.kobaco.kobaco_project.domain.advertisement;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Advertisement {
    private Long id;
    private String title;
    private String videoUrl;
    private String advertiser;
    private String agency;
    private String manufacturer;
    private Boolean isArchived;

    public Advertisement(Long id, String title, String videoUrl, String advertiser, String agency, String manufacturer, Boolean isArchived) {
        this.id = id;
        this.title = title;
        this.videoUrl = videoUrl;
        this.advertiser = advertiser;
        this.agency = agency;
        this.manufacturer = manufacturer;
        this.isArchived = isArchived;
    }

}
