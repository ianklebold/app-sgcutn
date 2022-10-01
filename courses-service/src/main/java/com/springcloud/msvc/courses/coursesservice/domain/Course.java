package com.springcloud.msvc.courses.coursesservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Name can't be null. Name is required")
    @NotEmpty(message = "Name can't be empty. Name is required")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Description can't be null. Description is required")
    @NotEmpty(message = "Description can't be empty. Description is required")
    private String description;

    @CreationTimestamp
    private LocalDate creationDate;

    @ManyToMany
    private List<CategoryCourse> category = new ArrayList<>();

    @Column(nullable = false)
    @PositiveOrZero(message = "The min value for price must be zero")
    private Double price;

    @Max(value = 100, message = "The max value for discount must be one hundred")
    private int discount;


    private int quantityStudents;

}
