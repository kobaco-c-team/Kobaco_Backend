package com.kobaco.kobaco_project.application.advertisement.dto.response;

import ch.qos.logback.core.testUtil.FileTestUtil;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.sql.Template;

import java.util.List;

public record AdvertisementAiAnalysisResponse<T> (
        String category,
        List<T> imageUrls
){
    public static AdvertisementAiAnalysisResponse of(String category, List<T> imageUrls){
        return new AdvertisementAiAnalysisResponse<>(category, imageUrls);
    }

}
