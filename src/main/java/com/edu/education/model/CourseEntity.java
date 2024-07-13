package com.edu.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseEntity {
    private Long id;
    private String coursename;
    private String description;
    private int instructorid;


}
