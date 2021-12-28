package com.training.keyskillback.repository;

import com.training.keyskillback.models.User;
import com.training.keyskillback.models.UserStatistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface UserStatisticRepository extends JpaRepository<UserStatistic, Long> {

    @Modifying
    @Query(value = "INSERT INTO user_stat (average_speed, difficulty_level, errors, exercise_time, length_symbols," +
            " name, exercise_id, user_id, execution_date)" +
            " VALUES (:average_speed, :difficulty_level, :errors, :exercise_time, :length_symbols, " +
            ":name, :exercise_id, :user_id, :execution_date)", nativeQuery = true)
    void addUserStatistic(@Param("average_speed") double average_speed, @Param("difficulty_level") String difficulty_level,
                     @Param("errors") int errors, @Param("exercise_time") double exercise_time, @Param("length_symbols") int length_symbols,
                     @Param("name") String name, @Param("exercise_id") Long exercise_id,
                     @Param("user_id") Long user_id, @Param("execution_date") String execution_date);
    public List<UserStatistic> findByUser_Id(Long user_id);
    @Modifying
    @Query(value = "DELETE FROM user_stat where user_id = :user_id", nativeQuery = true)
    void deleteUserStatisticById(@Param("user_id") Long user_id);
    @Modifying
    @Query(value = "DELETE FROM user_stat where exercise_id = :exercise_id", nativeQuery = true)
    void deleteUserStatisticByExercise_Id(@Param("exercise_id") Long exercise_id);
    Boolean existsByUser_Id(Long id);
    Boolean existsByExercise_Id(Long id);

}
