package com.training.keyskillback.repository;

import com.training.keyskillback.models.BlockedUsers;
import com.training.keyskillback.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface BlockedUsersRepository extends JpaRepository<BlockedUsers, Long> {
    Boolean existsByUser_Id(Long user_id);
    BlockedUsers getByUser_Id(Long user_id);
    @Modifying
    @Query(value = "DELETE FROM blocked_users where user_id = :user_id", nativeQuery = true)
    void deleteBlockOnUser(@Param("user_id") Long user_id);

    @Modifying
    @Query(value = "INSERT INTO blocked_users (begin_block, end_block, user_id)" +
            " VALUES (:begin_block, :end_block, :user_id)", nativeQuery = true)
    void blockUser(@Param("begin_block") Timestamp begin_block, @Param("end_block") Timestamp end_block,
                          @Param("user_id") Long user_id);
}
