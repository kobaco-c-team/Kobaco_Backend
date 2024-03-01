package com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity;

import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
import com.kobaco.kobaco_project.infrastructure.storage.expression.entity.ExpressionEntity;
import jakarta.persistence.*;
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
    private Long id;
    private String title;
    private String videoUrl;
    private String advertiser;
    private String agency;
    private String manufacturer;
    private Boolean isArchived = Boolean.FALSE;

    @OneToMany(mappedBy="advertisementEntity")
    private List<ExpressionEntity> expressionEntities = new ArrayList<>();

    private AdvertisementEntity(String title, String videoUrl, String advertiser, String agency, String manufacturer) {
        this.title = title;
        this.videoUrl = videoUrl;
        this.advertiser = advertiser;
        this.agency = agency;
        this.manufacturer = manufacturer;
    }

    public static AdvertisementEntity of(String title, String videoUrl, String advertiser, String agency, String manufacturer) {
        return new AdvertisementEntity(title, videoUrl, advertiser, agency, manufacturer);
    }
}
