package com.edu.education.controller;

import com.edu.education.model.CourseEntity;
import com.edu.education.service.CourseSerivce;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping("/courses")
    public class CourseController {

            private final CourseSerivce courseSerivce;

    public CourseController(CourseSerivce courseSerivce) {
        this.courseSerivce = courseSerivce;

    }

    //Get all available courses
    @GetMapping()
    public Set<CourseEntity> getAllCourses() {
        return courseSerivce.getAllCourses();
    }

    //Add Courses
    @PostMapping("/add")
    public ResponseEntity<?> saveCourse(@RequestBody CourseEntity courseEntity) {

        return new ResponseEntity<>(courseSerivce.addCourse(courseEntity), HttpStatus.OK);

    }
    //Get Courses by id
    @GetMapping("/course/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id){

        return ResponseEntity.status(HttpStatus.OK).body(courseSerivce.getCourseById(id));
    }

    //Update Courses
    @PostMapping("/update/{id}")
    public ResponseEntity<?> updateCourseById(@PathVariable Long id,@RequestBody CourseEntity course){
        if (courseSerivce.getCourseById(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }else {
        return ResponseEntity.status(HttpStatus.OK).body(courseSerivce.updateCourse(course,id));
    }}

    //Delete a Course by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long id){
        if (courseSerivce.getCourseById(id)==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course not found");
        }
        courseSerivce.deleteCourseById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
    }
}