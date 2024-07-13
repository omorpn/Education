package com.edu.education.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InstructorEntity {
    private Long id;
    private String name;
    private String address;
    private String phone;

}
