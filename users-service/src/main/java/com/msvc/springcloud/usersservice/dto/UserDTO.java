package com.msvc.springcloud.usersservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDTO {

    private String name;
    private String surname;
    private String email;
    private Long id;
}
