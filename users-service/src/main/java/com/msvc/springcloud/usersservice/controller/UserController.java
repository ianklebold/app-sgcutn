package com.msvc.springcloud.usersservice.controller;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;
import com.msvc.springcloud.usersservice.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user,@PathVariable Long id){
        User response = userService.giveUserExists(id);

        return (response != null)?
                ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(response)):
                userService.messageUserNotFound(id);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Boolean response = userService.checkMeUser(id);

        return (response)?
                ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.findUserById(id)):
                userService.messageUserNotFound(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id){
        Boolean response = userService.checkMeUser(id);
        if(response){
            userService.deleteUser(id);
            return ResponseEntity.status(HttpStatus.OK).body("User : "+id+" eliminated");
        }else{
            return userService.messageUserNotFound(id);
        }
    }

}
