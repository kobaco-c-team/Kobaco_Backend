package com.kobaco.kobaco_project.domain.advertisement.query;

import com.kobaco.kobaco_project.domain.advertisement.model.Advertisement;
import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.domain.advertisement.model.Mood;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AdvertisementRepository {
    Optional<Advertisement> findById(Long id);
    List<Advertisement> findAllByMoodList(List<Mood> moodList, Long advertisementId);
    void save(Advertisement advertisement);
    List<Advertisement> findAllBySort(String kwdVal, LocalDateTime start, LocalDateTime end, List<ExpressionType> expressionTypeList, List<String> moodTypeList);
    List<Advertisement> findAllByRelation(String kwdVal, LocalDateTime start, LocalDateTime end, List<ExpressionType> expressionTypeList, List<String> moodTypeList);
    List<Advertisement> findAllByArchiveWithExpression(String kwdVal, List<ExpressionType> expressionTypeList, List<String> moodTypeList);
    List<Advertisement> findAllByArchive(String kwdVal, List<String> moodTypeList);
}
