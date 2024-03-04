package com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity;

import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "advertisement")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdvertisementEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "advertisement_id")
    private Long id;
    private String title;
    private String videoUrl;
    private String advertiser;
    private String agency;
    private String manufacturer;
    private Boolean isArchived = Boolean.FALSE;


//    @OneToMany(mappedBy = "advertisementEntity")
//    private List<MoodEntity> moodEntities = new ArrayList<>();

    private LocalDateTime archivedAt;
    private AdvertisementEntity(Long id, String title, String videoUrl, String advertiser, String agency, String manufacturer, Boolean isArchived, LocalDateTime archivedAt) {
        this.id = id;
        this.title = title;
        this.videoUrl = videoUrl;
        this.advertiser = advertiser;
        this.agency = agency;
        this.manufacturer = manufacturer;
        this.isArchived = isArchived;
        this.archivedAt = archivedAt;
    }

    public static AdvertisementEntity of(Long id, String title, String videoUrl, String advertiser, String agency, String manufacturer, Boolean isArchived, LocalDateTime archivedAt) {
        return new AdvertisementEntity(id, title, videoUrl, advertiser, agency, manufacturer, isArchived, archivedAt);
    }
}
