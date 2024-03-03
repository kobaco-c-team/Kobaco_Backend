package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {
    private Long id;
    private String name;

    public static Item of(Long id, String name) {
        return new Item(id, name);
    }
}
