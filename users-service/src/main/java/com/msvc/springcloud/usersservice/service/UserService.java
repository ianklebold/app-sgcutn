package com.msvc.springcloud.usersservice.service;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> findAllUsers();
    Optional<User> findUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id);
    void deleteUser(Long id);
}
