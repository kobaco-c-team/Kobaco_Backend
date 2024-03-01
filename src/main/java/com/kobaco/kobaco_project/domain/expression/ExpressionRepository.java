package com.kobaco.kobaco_project.domain.expression;

import java.util.List;


public interface ExpressionRepository {
    List<Expression> findAllByAdvertisementId(Long advertisement_id);
}
