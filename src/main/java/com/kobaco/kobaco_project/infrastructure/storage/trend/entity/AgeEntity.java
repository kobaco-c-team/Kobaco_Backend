package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import com.kobaco.kobaco_project.domain.trend.model.AgeType;
import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "age")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AgeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "age_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private AgeType ageType;

    private Long ratio;

    private Long trendId;

    private AgeEntity(Long id, AgeType ageType, Long ratio, Long trendId) {
        this.id = id;
        this.ageType = ageType;
        this.ratio = ratio;
        this.trendId = trendId;
    }

}
