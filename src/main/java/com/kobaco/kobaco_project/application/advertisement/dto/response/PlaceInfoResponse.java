package com.kobaco.kobaco_project.application.advertisement.dto.response;

public record PlaceInfoResponse (String name){
    public static PlaceInfoResponse of(final String name){
        return new PlaceInfoResponse(name);
    }
}
