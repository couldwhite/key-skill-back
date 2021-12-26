package com.training.keyskillback.controllers;

import com.training.keyskillback.generator.Generator;
import com.training.keyskillback.models.Exercise;
import com.training.keyskillback.models.GeneralStatistic;
import com.training.keyskillback.pojo.CreateExerciseRequest;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.repository.ExerciseRepository;
import com.training.keyskillback.repository.GeneralStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/statistic")
public class GeneralStatisticController {

    @Autowired
    GeneralStatisticRepository generalStatisticRepository;

    @CrossOrigin
    @ResponseBody
    @Transactional
    @GetMapping("/getAllGeneralStatistics")
    public List getAllExercises() {
        List<GeneralStatistic> generalStatistics = generalStatisticRepository.findAll();
        return generalStatistics;
    }

    @Transactional
    @PostMapping("/changeNumberOfAttempts")
    public void changeNumberOfAttempts(@RequestParam String  id, @RequestParam boolean flag) {
        if (flag) {
            generalStatisticRepository.getById(Long.parseLong(id)).setSuccessfulAttempts(generalStatisticRepository.getById(Long.parseLong(id)).getSuccessfulAttempts() + 1);
        } else {
            generalStatisticRepository.getById(Long.parseLong(id)).setUnsuccessfulAttempts(generalStatisticRepository.getById(Long.parseLong(id)).getUnsuccessfulAttempts() + 1);
        }
    }
}
