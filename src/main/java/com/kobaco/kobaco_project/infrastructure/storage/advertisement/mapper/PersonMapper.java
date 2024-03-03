package com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper;

import com.kobaco.kobaco_project.domain.advertisement.model.Person;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {
    public Person toDomain(final PersonEntity personEntity) {
        return Person.of(
            personEntity.getId(),
            personEntity.getName()
        );
    }
}
