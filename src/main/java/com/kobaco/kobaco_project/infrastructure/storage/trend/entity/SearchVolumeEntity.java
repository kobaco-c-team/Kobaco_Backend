package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import com.kobaco.kobaco_project.infrastructure.storage.common.BaseEntity;
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

@Entity
@Table(name = "search_volume")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchVolumeEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_volume_id")
    private Long id;

    private LocalDateTime searchDate;

    private Long volume;

    private Long trendId;

    private SearchVolumeEntity(Long id, LocalDateTime searchDate, Long volume, Long trendId) {
        this.id = id;
        this.searchDate = searchDate;
        this.volume = volume;
        this.trendId = trendId;
    }

}
