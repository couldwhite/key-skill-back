package com.training.keyskillback.controllers;

import com.training.keyskillback.models.User;
import com.training.keyskillback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @ResponseBody
    @Transactional
    @GetMapping("/getAllUsers")
    public List getAllExercises() {
        List<User> userList = userRepository.findAll();
        int i = 1;
        return userList;
    }
}
