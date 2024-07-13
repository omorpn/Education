package com.edu.education.repository;

import com.edu.education.model.StudentEntity;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;

@Repository
public class StudentRepository {
    Collection<StudentEntity> students = new HashSet<>();

    public  StudentEntity addStudent(StudentEntity studentEntity){
        //Create Object of student

        //Create id for students
        studentEntity.setId(students.size()+(long)1);
        //add student to Collection
         students.add(studentEntity);
         return studentEntity;
    }
    //Get all students
    public Collection<StudentEntity> findAllStudents(){
        return students;
    }
    //Find student By id
    public StudentEntity findStudentById(long id){

        for(StudentEntity studentEntity:students){
            if(studentEntity.getId().equals(id)){
                return studentEntity;
            }
        }
        return null; //Return null if no student is found
    }

    //Remove student from list
    public void removeStudentById(long id){
        students.remove(findStudentById(id));
    }


}
