package com.training.keyskillback.repository;

import com.training.keyskillback.models.Role;
import com.training.keyskillback.models.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
    @Modifying
    @Query(value = "DELETE FROM user_roles where user_id = :user_id", nativeQuery = true)
    void deleteRoleById(@Param("user_id") Long user_id);
}
