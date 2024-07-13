package com.edu.education.service;

import com.edu.education.model.CourseEntity;
import com.edu.education.model.StudentEntity;
import com.edu.education.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Service
public class StudentService {
    //Student service Constructor
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {

        this.repository = repository;

    }
    //Find all students
    public Collection<StudentEntity> findAll() {

        return repository.findAllStudents();
    }
    //Save a student to list
    public StudentEntity save(StudentEntity entity) {

      StudentEntity student= StudentEntity.builder()
               .email(entity.getEmail())
               .studentname(entity.getStudentname())
              .dob(entity.getDob())
              .password(entity.getPassword())
              .enrolled(entity.getEnrolled())
               .build();
      return repository.addStudent(student);
    }
    //Update Student
    public  StudentEntity UpdateStudent(StudentEntity entity,Long id) {
       StudentEntity student= repository.findStudentById(id);
       student.setEmail(entity.getEmail());
       student.setStudentname(entity.getStudentname());
       student.setDob(entity.getDob());
       student.setPassword(entity.getPassword());
       student.setEnrolled(entity.getEnrolled());
       return student;

    }
    // Find student by id
    public Object findById(Long id) {
       return repository.findStudentById(id);
    }
    //Delete Student
    public void deleteById(Long id) {
         repository.removeStudentById(id);
    }
    // List of course student is enrolled for
    public List<CourseEntity> findCourseByStudentId(Long studentId) {
        StudentEntity student= repository.findStudentById(studentId);
        if(student!=null){
            return (List<CourseEntity>) student.getEnrolled();
        }else {
            return Collections.emptyList();
        }
    }
}
