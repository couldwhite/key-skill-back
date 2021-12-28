package com.training.keyskillback.repository;

import com.training.keyskillback.models.GeneralStatistic;
import com.training.keyskillback.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralStatisticRepository extends JpaRepository<GeneralStatistic, Long> {
    @Modifying
    @Query(value = "DELETE FROM general_stat where name = :name", nativeQuery = true)
    void deleteGeneralStatisticByExerciseName(@Param("name") String name);
}
