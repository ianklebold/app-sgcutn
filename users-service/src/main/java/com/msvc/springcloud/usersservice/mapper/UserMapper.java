package com.msvc.springcloud.usersservice.mapper;

import com.msvc.springcloud.usersservice.domain.User;
import com.msvc.springcloud.usersservice.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public List<UserDTO> mapperGetAllUser(List<User> users){

        List<UserDTO> usersDto = new ArrayList<>();

        users.stream()
                .map(user -> usersDto.add(UserDTO.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .email(user.getEmail())
                        .id(user.getId())
                        .build()))
                .collect(Collectors.toList());
        return usersDto;
    }

}
