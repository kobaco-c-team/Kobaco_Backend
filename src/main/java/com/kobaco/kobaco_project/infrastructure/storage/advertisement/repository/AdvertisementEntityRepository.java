package com.kobaco.kobaco_project.infrastructure.storage.advertisement.repository;

import com.kobaco.kobaco_project.domain.advertisement.model.ExpressionType;
import com.kobaco.kobaco_project.infrastructure.storage.advertisement.entity.AdvertisementEntity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AdvertisementEntityRepository extends JpaRepository<AdvertisementEntity, Long> {
    Optional<AdvertisementEntity> findAdvertisementEntityById(Long id);

    @Query("""
    select a from AdvertisementEntity a 
    left join ItemEntity i on i.advertisementEntity.id = a.id
    left join PersonEntity p on p.advertisementEntity.id = a.id
    where (:kwdVal is null or (:kwdVal is not null 
           and (a.title like %:kwdVal% 
           or i.name like %:kwdVal% 
           or p.name like %:kwdVal%)))
    and a.createdAt >= :start and a.createdAt <= :end order by a.createdAt desc
        """)
    List<AdvertisementEntity> findAllBySort(@Param("kwdVal") String kwdVal, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);


    @Query("""
    select a from AdvertisementEntity a 
    join ItemEntity i on i.advertisementEntity.id = a.id
    join PersonEntity p on p.advertisementEntity.id = a.id
    where (:kwdVal is null or (:kwdVal is not null 
           and (a.title like %:kwdVal% 
           or i.name like %:kwdVal% 
           or p.name like %:kwdVal%)))
    and a.createdAt >= :start and a.createdAt <= :end
    """)
    List<AdvertisementEntity> findAllByRelation(@Param("kwdVal") String kwdVal, @Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("""
    select a from AdvertisementEntity a
    join ItemEntity i on i.advertisementEntity.id = a.id
    join PersonEntity p on p.advertisementEntity.id = a.id
    join MoodEntity m on m.advertisementEntity.id = a.id
    join ExpressionEntity e on e.advertisementEntity.id = a.id
    where(:kwdVal is null or (:kwdVal is not null and (a.title like %:kwdVal% 
           or i.name like %:kwdVal% 
           or p.name like %:kwdVal% ) ))
    and (:expressionType is null or (:expressionType is not null and e.expressionType = :expressionType))
    and (:moodVal is null or (:moodVal is not null and m.type = :moodVal))
    and a.isArchived = true
    """)
    List<AdvertisementEntity> findAllByArchiveWithExpression(@Param("kwdVal") String kwdVal, @Param("expressionType") ExpressionType expressionType, @Param("moodVal") String moodVal);

    @Query("""
    select a from AdvertisementEntity a
    left join ItemEntity i on i.advertisementEntity.id = a.id
    left join PersonEntity p on p.advertisementEntity.id = a.id
    left join MoodEntity m on m.advertisementEntity.id = a.id
    where(:kwdVal is null or (:kwdVal is not null and (a.title like %:kwdVal% 
           or i.name like %:kwdVal% 
           or p.name like %:kwdVal% ) ))
    and (:moodVal is null or (:moodVal is not null and m.type = :moodVal))
    and a.isArchived = true
    """)
    List<AdvertisementEntity> findAllByArchive(@Param("kwdVal") String kwdVal, @Param("moodVal") String moodVal);
}
