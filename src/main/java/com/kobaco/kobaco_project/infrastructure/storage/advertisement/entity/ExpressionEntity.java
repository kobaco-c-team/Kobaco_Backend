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
    private Long advertisementId;

    private ExpressionEntity(ExpressionType expressionType, Double time, Long advertisementId){
        this.expressionType =expressionType;
        this.time=time;
        this.advertisementId =advertisementId;
    }

    public static ExpressionEntity of(ExpressionType expressionType, Double time, Long advertisementId){
        return new ExpressionEntity(expressionType,time,advertisementId);
    }
}
