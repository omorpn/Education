package com.edu.education.repository;

import com.edu.education.model.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CourseRepository {

    //List of all available Courses
    Set<CourseEntity> courses = new HashSet<>();


      public CourseEntity save(CourseEntity courseEntity) {
         courseEntity.setId(courses.size()+ (long)1);
         courses.add(courseEntity);

          return  courseEntity;
      }
      public Set<CourseEntity> findAll() {
          return courses;
      }

   //find course by id
    public CourseEntity findById(Long studentId) {
          //implement logic to find and return course by id
          for (CourseEntity courseEntity1 : courses) {
              if (courseEntity1.getId().equals(studentId)){
                  return courseEntity1;
              }
          }
     return null;//return null if the student is not found
    }
    //Delete Course by id
    public void deleteById(Long studentId) {
          //loop through the list
        courses.removeIf(courseEntity -> courseEntity.getId().equals(studentId));
    }
}
