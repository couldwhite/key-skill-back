package com.training.keyskillback.controllers;

import com.training.keyskillback.generator.Generator;
import com.training.keyskillback.models.Exercise;
import com.training.keyskillback.models.GeneralStatistic;
import com.training.keyskillback.pojo.CreateExerciseRequest;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.repository.ExerciseRepository;
import com.training.keyskillback.repository.GeneralStatisticRepository;
import com.training.keyskillback.repository.UserStatisticRepository;
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
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    GeneralStatisticRepository generalStatisticRepository;

    @Autowired
    ExerciseRepository exerciseRepository;

    @Autowired
    UserStatisticRepository userStatisticRepository;


    @Transactional
    @PostMapping("/createExercise")
    public ResponseEntity<?> createExercise(@RequestBody CreateExerciseRequest createExerciseRequest) {
        if (exerciseRepository.existsByName(createExerciseRequest.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Exercise is exist"));
        }
        String difficultyLevel;
        if (createExerciseRequest.getLevelNumber() == 1) {
            difficultyLevel = "Начальный";
        } else if (createExerciseRequest.getLevelNumber() == 2) {
            difficultyLevel = "Средний";
        } else {
            difficultyLevel = "Продвинутый";
        }
        GeneralStatistic generalStatistic = new GeneralStatistic(createExerciseRequest.getName(),
                difficultyLevel, 0, 0);
        generalStatisticRepository.save(generalStatistic);

        String keyZone = Arrays.toString(createExerciseRequest.getKeyZone()).replaceAll("\\[|\\]|\\,","");
        String masOfSymbols;
        if ("Автоматически".equals(createExerciseRequest.getCreatingWay())) {
            masOfSymbols = Generator.generateRandomString(createExerciseRequest.getLength(), keyZone);
        } else {
            masOfSymbols = createExerciseRequest.getMasOfSymbols();
        }
        exerciseRepository.addExercise(createExerciseRequest.getCreatingWay(), new Timestamp(new Date().getTime()),
                keyZone, createExerciseRequest.getLength(), createExerciseRequest.getLevelNumber(), masOfSymbols,
                createExerciseRequest.getMaxErrors(), createExerciseRequest.getMaxTimeKick(),createExerciseRequest.getName(),
                generalStatistic.getId());
//        Exercise exercise = new Exercise(createExerciseRequest.getLevelNumber(),keyZone, createExerciseRequest.getLength(),
//                createExerciseRequest.getMaxTimeKick(), createExerciseRequest.getMaxErrors(),
//                createExerciseRequest.getName(), masOfSymbols, createExerciseRequest.getCreatingWay());
//        exerciseRepository.save(exercise);


        return ResponseEntity.ok(new MessageResponse("Exercise CREATED"));
    }

    @Transactional
    @PostMapping("/deleteExercise")
    public ResponseEntity<?> deleteExercise(@RequestParam String id) {
        if (!exerciseRepository.existsById(Long.parseLong(id))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: exercises is not exist"));
        } else {
            String name = exerciseRepository.getById(Long.parseLong(id)).getName();
            if(userStatisticRepository.existsByExercise_Id(Long.parseLong(id))) {
                userStatisticRepository.deleteUserStatisticByExercise_Id(Long.parseLong(id));
            }
            exerciseRepository.deleteById(Long.parseLong(id));
            generalStatisticRepository.deleteGeneralStatisticByExerciseName(name);
        }
        return ResponseEntity.ok(new MessageResponse("Exercise DELETED"));
    }


    @ResponseBody
    @Transactional
    @GetMapping("/getAllExercises")
    public List getAllExercises() {
        List<Exercise> exerciseList = exerciseRepository.findAll();
        return exerciseList;
    }

    @ResponseBody
    @GetMapping("/getExerciseById")
    public Exercise getExercise(@RequestParam String id) {
        Exercise exercise = exerciseRepository.getById(Long.parseLong(id));
        return exercise;
    }
}
