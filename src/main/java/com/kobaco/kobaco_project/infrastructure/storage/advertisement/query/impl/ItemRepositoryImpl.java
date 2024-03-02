package com.kobaco.kobaco_project.infrastructure.storage.advertisement.query.impl;

import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import com.kobaco.kobaco_project.domain.advertisement.query.ItemRepository;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.mapper.ItemMapper;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository.ItemEntityRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {

    private final ItemEntityRepository itemEntityRepository;
    private final ItemMapper itemMapper;

    @Override
    public List<Item> findAllByAdvertisementId(Long advertisementId) {
        return itemEntityRepository.findAllByAdvertisementEntityId(advertisementId)
                .stream()
                .map(itemMapper::toDomain)
                .toList();
    }

}
