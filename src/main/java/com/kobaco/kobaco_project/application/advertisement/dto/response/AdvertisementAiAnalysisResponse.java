package com.kobaco.kobaco_project.application.advertisement.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AdvertisementAiAnalysisResponse<T> {
    private String category;
    private List<T> tags;
    private List<String> imageUrls;

}
