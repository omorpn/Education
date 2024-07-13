package com.edu.education.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {
    private Long id;
    private String studentname;
    private String password;
    private String email;
    private Date dob;

    private Collection<CourseEntity> enrolled;
}
