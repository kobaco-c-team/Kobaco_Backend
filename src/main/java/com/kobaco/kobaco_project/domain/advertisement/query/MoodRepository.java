package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Mood;
import java.util.List;

public interface MoodRepository {
    List<Mood> findAllByAdvertisementId(Long advertisementId);
}
