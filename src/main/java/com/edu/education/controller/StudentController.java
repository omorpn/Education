package com.edu.education.controller;

import com.edu.education.model.CourseEntity;
import com.edu.education.model.StudentEntity;
import com.edu.education.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    //Find all Students
    @GetMapping()
    public ResponseEntity<?> findAllStudents(){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.findAll());
    }
    //Find student by id
    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentsById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.findById(id));
    }
    //Add a student
    @PostMapping("/add")
    public  ResponseEntity<?> addStudent(@RequestBody StudentEntity student){
        System.out.println(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(student)) ;
    }
    //Update student
    @PutMapping("/update/{id}")
    public ResponseEntity<?>  updateStudent(@PathVariable Long id,@RequestBody StudentEntity student){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.UpdateStudent(student,id));
    }
    //Delete Student details
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        if(id!=null) {
            studentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    //find Courses Student Enrolled
    @GetMapping("/course/{id}")
    public List<CourseEntity> findCoursesByStudentId(@PathVariable Long id){
        return studentService.findCourseByStudentId(id);
    }
}
