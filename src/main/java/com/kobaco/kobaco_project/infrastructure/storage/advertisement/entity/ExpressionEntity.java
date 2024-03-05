package com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity;

import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "expression")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ExpressionEntity  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExpressionType expressionType;
    private Double time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advertisement_id")
    private AdvertisementEntity advertisementEntity;

    private ExpressionEntity(ExpressionType expressionType, Double time, AdvertisementEntity advertisementEntity){
        this.expressionType =expressionType;
        this.time=time;
        this.advertisementEntity = advertisementEntity;
    }

}
