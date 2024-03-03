package com.kobaco.kobaco_project.domain.advertisement.query;


import com.kobaco.kobaco_project.domain.advertisement.model.Image;

import java.util.List;

public interface ImageRepository {
    List<Image> findAllByType(String type);
}
