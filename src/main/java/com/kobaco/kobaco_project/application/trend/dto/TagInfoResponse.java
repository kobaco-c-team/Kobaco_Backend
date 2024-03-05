package com.kobaco.kobaco_project.application.trend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
public record TagInfoResponse (
        String name,
        @JsonInclude(JsonInclude.Include.NON_NULL) Integer count
){

    public static TagInfoResponse from(Tag tag){
        return new TagInfoResponse.builder()
                .name(tag.getName())
                .count(tag.getCount())
                .build();
    }
}
