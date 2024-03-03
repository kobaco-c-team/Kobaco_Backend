package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Image;
import com.kobaco.kobaco_project.domain.advertisement.query.ImageRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainService
@RequiredArgsConstructor
public class ReadAiAnalysis {

    private final ImageRepository imageRepository;
    public List<String> readAiAnalysis(Long advertisementId, String category) {
        return imageRepository.findAllByType(category)
                .stream()
                .map(Image::getType)
                .toList();
    }
}
