package com.training.keyskillback.controllers;


import com.training.keyskillback.models.DifficultyLevel;
import com.training.keyskillback.pojo.DifficultyLevelRequest;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.repository.DifficultyLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/difficultyLevel")
public class DifficultyLevelController {

    @Autowired
    DifficultyLevelRepository difficultyLevelRepository;

    @PostMapping("/createDifficultyLevel")
    public ResponseEntity<?> createDifficultyLevel(@RequestBody DifficultyLevelRequest difficultyLevelRequest) {
        if (difficultyLevelRepository.existsById(difficultyLevelRequest.getIdLevel())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: DifficultyLevel is exist"));
        }
        DifficultyLevel difficultyLevel = new DifficultyLevel(difficultyLevelRequest.getIdLevel(), difficultyLevelRequest.getLength(),
                difficultyLevelRequest.getKeyZone(), difficultyLevelRequest.getMaxTimeKick(), difficultyLevelRequest.getMaxErrors());


        difficultyLevelRepository.save(difficultyLevel);
        return ResponseEntity.ok(new MessageResponse("DifficultyLevel CREATED"));
    }
}