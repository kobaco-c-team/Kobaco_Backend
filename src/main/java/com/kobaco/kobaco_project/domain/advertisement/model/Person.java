package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {
    private Long id;
    private String name;

    public static Person of(Long id, String name) {
        return new Person(id, name);
    }
}
