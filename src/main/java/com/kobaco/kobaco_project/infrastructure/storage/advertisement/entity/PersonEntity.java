package com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity;

import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id")
    private AdvertisementEntity advertisementEntity;


    private PersonEntity(Long id, String name, AdvertisementEntity advertisementEntity) {
        this.id = id;
        this.name = name;
        this.advertisementEntity = advertisementEntity;
    }
}
