package com.springcloud.msvc.courses.coursesservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories_course")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotNull(message = "Name can't be null. Name is required")
    @NotEmpty(message = "Name can't be empty. Name is required")
    private String name;

    @ManyToMany
    private List<Course> courses = new ArrayList<>();


}
