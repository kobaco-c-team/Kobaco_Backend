package com.kobaco.kobaco_project.domain.trend.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.trend.model.ContentArchiving;
import com.kobaco.kobaco_project.domain.trend.query.ContentArchivingRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadContentArchiving {
    private final ContentArchivingRepository contentArchivingRepository;
    public List<ContentArchiving> readContentArchiving(String trendKwd, String order) {
        return contentArchivingRepository.findAllByKeyword(trendKwd, order);
    }
}
