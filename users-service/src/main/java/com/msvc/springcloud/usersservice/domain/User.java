package com.msvc.springcloud.usersservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Name can't be null. Name is required")
    @NotEmpty(message = "Name can't be empty. Name is required")
    @Pattern(regexp="[^0-9]*", message = "Name is not valid")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Surname can't be null. Surname is required")
    @NotEmpty(message = "Surname can't be empty. Surname is required")
    @Pattern(regexp = "[^0-9]*",message = "Surname is not valid")
    private String surname;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Email can't be null. Name is required")
    @NotEmpty(message = "Email can't be empty. Email is required")
    @Email(message = "Email is not valid",
            regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x" +
                    "0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@" +
                    "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2" +
                    "[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                    "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\" +
                    "x0e-\\x7f])+)\\])")
    private String email;

    @Column(nullable = false)
    @Size(min = 8, message = "Password required a size of 8 characters")
    @NotNull(message = "Password can't be null. Password is required")
    private String password;
}
