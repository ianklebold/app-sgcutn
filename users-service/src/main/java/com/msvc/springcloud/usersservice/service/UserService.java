package com.msvc.springcloud.usersservice.service;

import com.msvc.springcloud.usersservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
    User saveUser(User user);
    User updateUser(Long id);
    void deleteUser(Long id);
}
