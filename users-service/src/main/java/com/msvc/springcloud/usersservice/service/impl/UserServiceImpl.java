package com.msvc.springcloud.usersservice.service.impl;

import com.msvc.springcloud.usersservice.commons.GlobalExceptionHandler;
import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;
import com.msvc.springcloud.usersservice.mapper.UserMapper;
import com.msvc.springcloud.usersservice.repository.UserRepository;
import com.msvc.springcloud.usersservice.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDTO findUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        try {
            return userMapper.mapperGetDetailUser(user.orElseThrow());
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public ResponseEntity<?> messageUserNotFound(Long id){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("User with id : "+id+" not exists");
    }

    @Override
    @Transactional(readOnly = true)
    public User giveUserExists(Long id) {
        try {
            return userRepository.findById(id).orElseThrow();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    @Transactional
    public User saveUser(User user) {return userRepository.save(user);}

    @Override
    @Transactional(readOnly = true)
    public Boolean checkMeUser(Long id) {return userRepository.findById(id).isPresent();}

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> findAllUsers() {return userMapper.mapperGetAllUser(userRepository.findAll());}

    @Override
    @Transactional
    public void deleteUser(Long id) {userRepository.deleteById(id);}
}
