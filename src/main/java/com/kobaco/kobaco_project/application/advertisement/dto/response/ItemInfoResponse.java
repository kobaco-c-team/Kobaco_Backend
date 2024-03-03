package com.kobaco.kobaco_project.application.advertisement.dto.response;

public record ItemInfoResponse(String name) {
    public static ItemInfoResponse of(final String name) {
        return new ItemInfoResponse(name);
    }
}
