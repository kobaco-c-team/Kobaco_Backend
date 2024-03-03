package com.kobaco.kobaco_project.application.advertisement.dto.response;

public record PersonInfoResponse(String name) {
    public static PersonInfoResponse of(final String name) {
        return new PersonInfoResponse(name);
    }
}
