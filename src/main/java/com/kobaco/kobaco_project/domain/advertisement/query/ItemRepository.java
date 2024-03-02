package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Item;
import java.util.List;

public interface ItemRepository {
    List<Item> findAllByAdvertisementId(Long advertisementId);
}
