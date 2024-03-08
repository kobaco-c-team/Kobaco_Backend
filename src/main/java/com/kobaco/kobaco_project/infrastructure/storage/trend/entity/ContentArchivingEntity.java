package com.kobaco.kobaco_project.infrastructure.storage.trend.entity;

import com.kobaco.kobaco_project.domain.trend.model.PostType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "contentArchiving")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ContentArchivingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contentArchiving_id")
    private Long id;

    private String imageUrl;
    private String title;
    private String content;
    private LocalDateTime archivedAt;
    private Integer relevance;

    @Enumerated(EnumType.STRING)
    private PostType postType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trend_id")
    private TrendEntity trendEntity;
}
