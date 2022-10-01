package com.msvc.springcloud.usersservice.service;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO findUserById(Long id);
    User saveUser(User user);
    Boolean checkMeUser(Long id);
    User giveUserExists(Long id);
    void deleteUser(Long id);
    ResponseEntity<?> messageUserNotFound(Long id);
}
