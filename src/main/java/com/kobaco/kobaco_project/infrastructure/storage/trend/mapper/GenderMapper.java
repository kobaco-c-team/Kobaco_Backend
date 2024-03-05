package com.kobaco.kobaco_project.infrastructure.storage.trend.mapper;

import com.kobaco.kobaco_project.domain.trend.model.Gender;
import com.kobaco.kobaco_project.infrastructure.storage.trend.entity.GenderEntity;
import org.springframework.stereotype.Component;

@Component
public class GenderMapper {
    public Gender toDomain(final GenderEntity genderEntity) {
        return Gender.of(genderEntity.getGenderType(), genderEntity.getRatio());
    }
}
