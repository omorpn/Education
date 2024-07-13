package com.edu.education.service;

import com.edu.education.model.InstructorEntity;
import com.edu.education.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;

    }
    //Findbyid
    public Long findById(long id) {
        return instructorRepository.findInstructorById(id).getId();
    }
    //GetAll
    public Collection<InstructorEntity> getall(){
        return instructorRepository.findAll();
    }
    //Create
    public InstructorEntity Create(InstructorEntity instructorEntity) {
        return instructorRepository.register(instructorEntity);
    }
    //delete
    public String delete(long instructorId) {
        return instructorRepository.delete(instructorId);
    }
    //Update
    public InstructorEntity update(InstructorEntity instructorEntity, long instructorId) {
        InstructorEntity instructor=instructorRepository.findInstructorById(instructorId);
        instructor.setName(instructorEntity.getName());
        instructor.setAddress(instructorEntity.getAddress());
        instructor.setPhone(instructorEntity.getPhone());
        return instructor;
    }
}
