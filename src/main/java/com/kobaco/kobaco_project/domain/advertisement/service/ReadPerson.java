package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Person;
import com.kobaco.kobaco_project.domain.advertisement.query.PersonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadPerson {
    private final PersonRepository personRepository;

    public List<Person> getPerson(Long advertisementId) {
        return personRepository.findAllByAdvertisementId(advertisementId);
    }
}
