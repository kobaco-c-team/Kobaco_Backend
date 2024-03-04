package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Expression;

import java.util.List;


public interface ExpressionRepository {
    List<Expression> findAllByAdvertisementId(Long advertisement_id);
    List<Expression> findExpressionIdsByAdvertisementIds(List<Long> advertisementIds);
}
