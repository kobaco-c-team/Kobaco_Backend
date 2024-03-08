package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Long id;

    private String platform;
    private Integer count;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trend_id")
    private TrendEntity trendEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "content_id")
    private ContentEntity contentEntity;

}
