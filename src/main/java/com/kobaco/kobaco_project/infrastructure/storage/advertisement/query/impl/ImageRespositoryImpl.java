package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;


import com.kobaco.kobaco_project.domain.advertisement.model.Image;
import com.kobaco.kobaco_project.domain.advertisement.query.ImageRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.ImageMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.ImageEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ImageRespositoryImpl implements ImageRepository {

    private final ImageEntityRepository imageEntityRepository;
    private final ImageMapper imageMapper;
    @Override
    public List<Image> findAllByType(String type) {
        return imageEntityRepository.findAllByType(type)
                .stream()
                .map(imageMapper::toDomain)
                .toList();

    }
}
