package com.msvc.springcloud.usersservice.service.impl;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;
import com.msvc.springcloud.usersservice.mapper.UserMapper;
import com.msvc.springcloud.usersservice.repository.UserRepository;
import com.msvc.springcloud.usersservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {return userMapper.mapperGetAllUser(userRepository.findAll());}

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user;
    }

    @Override
    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User updateUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        return userRepository.save(user.get());


    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
