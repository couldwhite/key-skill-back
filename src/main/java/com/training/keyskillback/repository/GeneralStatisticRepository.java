package com.training.keyskillback.repository;

import com.training.keyskillback.models.GeneralStatistic;
import com.training.keyskillback.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralStatisticRepository extends JpaRepository<GeneralStatistic, Long> {
}
