package com.kobaco.kobaco_project.application.advertisement.dto.response;

public record MoodInfoResponse(String type) {
    public static MoodInfoResponse of(final String type) {
        return new MoodInfoResponse(type);
    }
}
