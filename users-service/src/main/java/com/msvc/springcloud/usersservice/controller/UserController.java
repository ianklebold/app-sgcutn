package com.msvc.springcloud.usersservice.controller;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;
import com.msvc.springcloud.usersservice.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public User saveUser(@Valid @RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping
    public List<UserDTO> getAllUsers(){return userService.findAllUsers();}
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id).get();
    }
}
