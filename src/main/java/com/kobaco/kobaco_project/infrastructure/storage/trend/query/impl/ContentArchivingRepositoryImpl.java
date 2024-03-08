package com.kobaco.kobaco_project.infrastructure.storage.trend.query.impl;

import com.kobaco.kobaco_project.domain.trend.model.ContentArchiving;
import com.kobaco.kobaco_project.domain.trend.model.OrderType;
import com.kobaco.kobaco_project.domain.trend.query.ContentArchivingRepository;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.ContentArchivingEntity;
import com.kobaco.kobaco_project.infrastructure.storage.trend.mapper.ContentArchivingMapper;
import com.kobaco.kobaco_project.infrastructure.storage.trend.repository.ContentArchivingEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ContentArchivingRepositoryImpl implements ContentArchivingRepository {
    private final ContentArchivingEntityRepository contentArchivingEntityRepository;
    private final ContentArchivingMapper contentArchivingMapper;
    @Override
    public List<ContentArchiving> findAllByKeyword(String trendKwd, String order) {
        List<ContentArchivingEntity> contentArchivingEntityList = contentArchivingEntityRepository.findAllByKeywordEntityName(trendKwd);

        if(order.equals(OrderType.RECENT.getDescription())){
            return contentArchivingEntityList.stream()
                    .sorted(Comparator.comparing(ContentArchivingEntity::getArchivedAt))
                    .map(contentArchivingMapper::toDomain)
                    .toList();
        }else if(order.equals(OrderType.RELEVANT.getDescription())){
            return contentArchivingEntityList.stream()
                    .sorted(Comparator.comparing(ContentArchivingEntity::getRelevance))
                    .map(contentArchivingMapper::toDomain)
                    .toList();
        }

        return contentArchivingEntityList.stream()
                .map(contentArchivingMapper::toDomain)
                .toList();
    }
}
