package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "content")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    private Long id;

    private String imageUrl;
    private String title;
    private Integer likes;
    private String publisher;
    private String platform;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trend_id")
    private TrendEntity trendEntity;
}
