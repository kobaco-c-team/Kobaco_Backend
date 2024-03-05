package com.kobaco.kobaco_project.domain.advertisement.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Expression {
    private Long id;
    private ExpressionType type;
    private Double time;
    private Long advertisement_id;

    public static Expression of(Long id, ExpressionType type, Double time, Long advertisement_id){
        return new Expression(id,type,time,advertisement_id);
    }
}
