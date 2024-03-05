package com.kobaco.kobaco_project.domain.trend.query;

import com.kobaco.kobaco_project.domain.trend.model.SearchVolume;
import java.util.List;

public interface SearchVolumeRepository {
    List<SearchVolume> findAllByTrendId(Long trendId);
}
