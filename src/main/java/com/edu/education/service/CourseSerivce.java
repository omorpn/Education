package com.edu.education.service;

import com.edu.education.model.CourseEntity;
import com.edu.education.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service
public class CourseSerivce {

    //Injects Course repository
    @Autowired
    private CourseRepository courseRepository;

    //All courses
    public CourseEntity addCourse(CourseEntity courseEntity) {

        return courseRepository.save(courseEntity);
    }

    //Get all available courses
    public Set<CourseEntity> getAllCourses() {
        return courseRepository.findAll();
    }

    //Update courses
    public  CourseEntity updateCourse(CourseEntity courseEntity, Long id) {
        CourseEntity course = courseRepository.findById(id);
        course.setCoursename(courseEntity.getCoursename());
        course.setDescription(courseEntity.getDescription());
        course.setInstructorid(courseEntity.getInstructorid());

        return course;
    }

    //Find Course by id
    public CourseEntity getCourseById(Long id) {
        return courseRepository.findById(id); //Return course by id

    }

    // Delete Course By Id
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }
}
