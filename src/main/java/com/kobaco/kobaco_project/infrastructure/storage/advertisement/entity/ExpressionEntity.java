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
    private ExpressionType expressionType;
    private Double time;

    @ManyToOne
    @JoinColumn(name="advertisement_id", nullable = false)
    private AdvertisementEntity advertisementEntity;

    private ExpressionEntity(ExpressionType expressionType, Double time, AdvertisementEntity advertisementEntity){
        this.expressionType =expressionType;
        this.time=time;
        this.advertisementEntity =advertisementEntity;
    }

    public static ExpressionEntity of(ExpressionType expressionType, Double time, AdvertisementEntity advertisementEntity){
        return new ExpressionEntity(expressionType,time,advertisementEntity);
    }
}
