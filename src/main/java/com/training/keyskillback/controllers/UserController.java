package com.training.keyskillback.controllers;

import com.training.keyskillback.models.RoleEnum;
import com.training.keyskillback.models.User;
import com.training.keyskillback.repository.RoleRepository;
import com.training.keyskillback.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @ResponseBody
    @Transactional
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().filter(
                user -> user.getRoles().contains(roleRepository.findByName(RoleEnum.ROLE_USER).get())
        ).collect(Collectors.toList());
    }
}
