package com.training.keyskillback.controllers;

import com.training.keyskillback.models.Exercise;
import com.training.keyskillback.models.RoleEnum;
import com.training.keyskillback.models.UserStatistic;
import com.training.keyskillback.pojo.CreateExerciseRequest;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.pojo.UserStatisticRequest;
import com.training.keyskillback.repository.ExerciseRepository;
import com.training.keyskillback.repository.UserStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/statistic")
public class UserStatisticController {
    @Autowired
    UserStatisticRepository userStatisticRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @Transactional
    @PostMapping("/addUserStatistic")
    public void addUserStatistic(@RequestBody UserStatisticRequest userStatisticRequest) {
        Long id_exercise = userStatisticRequest.getId_exercise();
        Exercise exercise = exerciseRepository.getById(id_exercise);
        String name = exercise.getName();
        int length = exercise.getLength();
        String difficultyLevel;
        if (exercise.getLevelNumber() == 1) {
            difficultyLevel = "Начальный";
        } else if (exercise.getLevelNumber() == 2) {
            difficultyLevel = "Средний";
        } else {
            difficultyLevel = "Продвинутый";
        }
        Date execution_date = new Timestamp(new Date().getTime());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(new Date());
        userStatisticRepository.addUserStatistic(userStatisticRequest.getAverage_speed(), difficultyLevel, userStatisticRequest.getErrors(),
                userStatisticRequest.getExercise_time(), length, name, userStatisticRequest.getId_exercise(), userStatisticRequest.getId_user(), date);
    }
    @ResponseBody
    @Transactional
    @GetMapping("/getAllUserStatistic")
    public List<UserStatistic> getAllUserStatistic(@RequestParam String id) {
        return userStatisticRepository.findByUser_Id(Long.parseLong(id));
    }
    @ResponseBody
    @Transactional
    @GetMapping("/count")
    public long count(@RequestParam String id) {
        return userStatisticRepository.findByUser_Id(Long.parseLong(id)).size();
    }
}
