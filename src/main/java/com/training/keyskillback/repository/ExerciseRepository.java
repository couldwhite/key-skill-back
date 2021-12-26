package com.training.keyskillback.repository;

import com.training.keyskillback.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> findByName(String name);

    Boolean existsByName(String name);

    @Modifying
    @Query(value = "INSERT INTO exercises (creating_way, begin_timestamp, key_zone, length, level_number," +
            " mas_of_symbols, max_errors, max_time_kick, name, general_statistic_id)" +
            " VALUES (:creating_way, :begin_timestamp, :key_zone, :length, :level_number, " +
                    ":mas_of_symbols, :max_errors, :max_time_kick, :name, :general_statistic_id)", nativeQuery = true)
    void addExercise(@Param("creating_way") String creating_way, @Param("begin_timestamp") Timestamp begin_timestamp,
                     @Param("key_zone") String key_zone, @Param("length") int length, @Param("level_number") int level_number,
                     @Param("mas_of_symbols") String mas_of_symbols, @Param("max_errors") int max_errors,
                     @Param("max_time_kick") int max_time_kick, @Param("name") String name, @Param("general_statistic_id") Long general_statistic_id);
}
