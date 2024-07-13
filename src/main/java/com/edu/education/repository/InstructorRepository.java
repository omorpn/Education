package com.edu.education.repository;

import com.edu.education.model.InstructorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;



@Repository
public class InstructorRepository {
    //Create a storage system for Instructors
    Collection<InstructorEntity> instructor = new ArrayList<>();

    // Find instructor by id
    public InstructorEntity findInstructorById(long id) {

       for (InstructorEntity instructor : instructor) {
           if (instructor.getId() == id) {
              return instructor;
           }
       }
       return null;
    }
    //find All instructors
    public Collection<InstructorEntity> findAll() {
        return instructor;
    }
    //Create
    public InstructorEntity register(InstructorEntity instructorEntity) {
        instructorEntity.setId(instructor.size() + (long) 1);
        instructor.add(instructorEntity);
        return instructorEntity;
    }
    //delete
    public String delete(long instructorId) {
        instructor.removeIf(f -> f.getId() == instructorId);
        return "Instructor deleted successfully";
    }

}
