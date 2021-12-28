package com.training.keyskillback.repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.training.keyskillback.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.keyskillback.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	User getByUsername(String username);
}
