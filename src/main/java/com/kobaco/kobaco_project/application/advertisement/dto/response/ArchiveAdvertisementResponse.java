package com.kobaco.kobaco_project.application.advertisement.dto.response;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import java.util.List;

public record ArchiveAdvertisementResponse(Long advertisementId, String title, String videoUrl,
                                           ExpressionType topExpression, boolean isArchived, List<MoodInfoResponse> moodInfo) {

    public static ArchiveAdvertisementResponse from(final Advertisement advertisement, final ExpressionType expressionType, final List<MoodInfoResponse> moodInfo) {
        return new ArchiveAdvertisementResponse(advertisement.getId(), advertisement.getTitle(), advertisement.getVideoUrl(),
                expressionType, advertisement.getIsArchived(), moodInfo);
    }
}
