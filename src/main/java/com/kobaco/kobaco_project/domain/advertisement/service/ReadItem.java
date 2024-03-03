package com.kobaco.kobaco_project.domain.advertisement.service;

import com.kobaco.kobaco_project.common.annotation.DomainService;
import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import com.kobaco.kobaco_project.domain.advertisement.query.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@DomainService
@RequiredArgsConstructor
public class ReadItem {
    private final ItemRepository itemRepository;

    public List<Item> getItem(Long advertisementId) {
        return itemRepository.findAllByAdvertisementId(advertisementId);
    }
}
