package com.training.keyskillback.controllers;

import com.training.keyskillback.models.Exercise;
import com.training.keyskillback.pojo.CreateExerciseRequest;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    ExerciseRepository exerciseRepository;


    @Transactional
    @PostMapping("/createExercise")
    public ResponseEntity<?> createExercise(@RequestBody CreateExerciseRequest createExerciseRequest) {
        if (exerciseRepository.existsByName(createExerciseRequest.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is exist"));
        }
        String keyZone = Arrays.toString(createExerciseRequest.getKeyZone()).replaceAll("\\[|\\]|\\,","");
        Exercise exercise = new Exercise(createExerciseRequest.getLevelNumber(),keyZone, createExerciseRequest.getLength(),
                createExerciseRequest.getMaxTimeKick(), createExerciseRequest.getMaxErrors(),
                createExerciseRequest.getName(), createExerciseRequest.getMasOfSymbols(), createExerciseRequest.getCreatingWay());
        exerciseRepository.save(exercise);
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
            exerciseRepository.deleteById(Long.parseLong(id));
        }
        return ResponseEntity.ok(new MessageResponse("Exercise DELETED"));
    }

    @CrossOrigin
    @ResponseBody
    @Transactional
    @GetMapping("/getAllExercises")
    public List getAllExercises() {
        List<Exercise> exerciseList = exerciseRepository.findAll();
        return exerciseList;
    }
}
