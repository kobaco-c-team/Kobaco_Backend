package com.kobaco.kobaco_project.domain.advertisement.model;

import java.time.LocalDateTime;
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
    private LocalDateTime archivedAt;
    private LocalDateTime createdAt;

    public static Advertisement of(Long id, String title, String videoUrl, String advertiser, String agency, String manufacturer, Boolean isArchived, LocalDateTime archivedAt
            , LocalDateTime createdAt) {
        return new Advertisement(id, title, videoUrl, advertiser, agency, manufacturer, isArchived, archivedAt, createdAt);
    }

    public void archive() {
        if(this.isArchived) {
            this.isArchived = false;
        }
        else {
            this.isArchived = true;
            archivedAt = LocalDateTime.now();
        }
    }

}
