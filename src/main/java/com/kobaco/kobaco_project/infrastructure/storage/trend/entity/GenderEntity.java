package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import com.kobaco.kobaco_project.domain.trend.model.GenderType;
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
@Table(name = "gender")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GenderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gender_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    private Long ratio;

    private Long trendId;

    private GenderEntity (Long id, GenderType genderType, Long ratio, Long trendId) {
        this.id = id;
        this.genderType = genderType;
        this.ratio = ratio;
        this.trendId = trendId;
    }

}
