package com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "place")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id")
    private AdvertisementEntity advertisementEntity;


    private PlaceEntity(Long id,String name, AdvertisementEntity advertisementEntity) {
        this.id = id;
        this.name = name;
        this.advertisementEntity = advertisementEntity;
    }
}
