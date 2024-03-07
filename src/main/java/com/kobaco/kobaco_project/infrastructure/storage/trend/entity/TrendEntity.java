package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Trend")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TrendEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trend_id")
    private Long id;

    private String trendKeyword;

    private TrendEntity(Long id, String trendKeyword) {
        this.id = id;
        this.trendKeyword = trendKeyword;
    }

}
