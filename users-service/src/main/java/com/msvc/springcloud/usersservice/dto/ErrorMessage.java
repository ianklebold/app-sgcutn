package com.msvc.springcloud.usersservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorMessage {
    private Boolean error;
    private String message;
    private int code;
}
