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
    @Query(value = "INSERT INTO exercises (creating_way, begin_timestamp, mas_of_symbols, name, id_level) VALUES (:b, :c, :d, :e, :f)", nativeQuery = true)
    void addExercise(@Param("b") String b, @Param("c") Timestamp с, @Param("d") String d, @Param("e") String e, @Param("f") Long f);
}
