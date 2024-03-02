package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Person;
import java.util.List;

public interface PersonRepository {
    List<Person> findAllByAdvertisementId(Long advertisementId);
}
