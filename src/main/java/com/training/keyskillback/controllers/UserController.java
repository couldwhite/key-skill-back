package com.training.keyskillback.controllers;

import com.training.keyskillback.models.Exercise;
import com.training.keyskillback.models.RoleEnum;
import com.training.keyskillback.models.User;
import com.training.keyskillback.pojo.MessageResponse;
import com.training.keyskillback.repository.RoleRepository;
import com.training.keyskillback.repository.UserRepository;
import com.training.keyskillback.repository.UserStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserStatisticRepository userStatisticRepository;

    @ResponseBody
    @Transactional
    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll().stream().filter(
                user -> user.getRoles().contains(roleRepository.findByName(RoleEnum.ROLE_USER).get())
        ).collect(Collectors.toList());
    }

    @Transactional
    @PostMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam String id) {
        if (!userRepository.existsById(Long.parseLong(id))) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: user is not exist"));
        } else {
            if(userStatisticRepository.existsByUser_Id(Long.parseLong(id))) {
                userStatisticRepository.deleteUserStatisticById(Long.parseLong(id));
            }
            roleRepository.deleteRoleById(Long.parseLong(id));
            userRepository.deleteById(Long.parseLong(id));
        }
        return ResponseEntity.ok(new MessageResponse("user DELETED"));
    }

    @ResponseBody
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam String id) {
        return userRepository.getById(Long.parseLong(id));
    }

    @ResponseBody
    @GetMapping("/getUserByName")
    public User getUserByName(@RequestParam String name) {
        return userRepository.getByUsername(name);
    }
}
