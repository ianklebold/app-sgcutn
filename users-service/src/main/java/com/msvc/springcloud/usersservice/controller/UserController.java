package com.msvc.springcloud.usersservice.controller;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public User saveUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping
    public User getUserById(Long id){
        return userService.findUserById(id).get();
    }

}
