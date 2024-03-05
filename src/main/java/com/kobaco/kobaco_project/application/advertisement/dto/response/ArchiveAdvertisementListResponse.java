package com.kobaco.kobaco_project.application.advertisement.dto.response;

import java.util.List;

public record ArchiveAdvertisementListResponse(List<ArchiveAdvertisementResponse> archiveAdvertisementResponseList) {

    public static ArchiveAdvertisementListResponse of(final List<ArchiveAdvertisementResponse> archiveAdvertisementResponseList) {
        return new ArchiveAdvertisementListResponse(archiveAdvertisementResponseList);
    }

}
