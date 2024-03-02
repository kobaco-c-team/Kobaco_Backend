package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Person;
import com.kobaco.kobaco_project.domain.advertisement.query.PersonRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.PersonMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.PersonEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryImpl implements PersonRepository {

    private final PersonEntityRepository personEntityRepository;
    private final PersonMapper personMapper;

    @Override
    public List<Person> findAllByAdvertisementId(Long advertisementId) {
        return personEntityRepository.findAllByAdvertisementEntityId(advertisementId)
                .stream()
                .map(personMapper::toDomain)
                .toList();
    }
}
