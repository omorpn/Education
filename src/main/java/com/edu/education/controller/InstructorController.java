package com.edu.education.controller;

import com.edu.education.model.InstructorEntity;
import com.edu.education.service.InstructorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("instructor")
public class InstructorController {
    private final InstructorService instructorService;


    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    //Get all instructor
    @GetMapping
    public ResponseEntity<?> getAllInstructors() {
        return ResponseEntity.ok(instructorService.getall());
    }
    //Create
    @PostMapping("/add")
    public ResponseEntity<?> addInstructor(@RequestBody InstructorEntity instructor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(instructorService.Create(instructor));
    }
    //Update
    @PostMapping("/update/{id}")
    public InstructorEntity updateInstructor(@PathVariable Long id, @RequestBody InstructorEntity instructor) {
        return instructorService.update(instructor,id);
    }
    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable Integer id) {
        return instructorService.delete(id);
    }
    //Find By id
    @GetMapping("/instructor/{id}")
    public ResponseEntity<?> getInstructorById(@PathVariable Long id) {
        return  ResponseEntity.status(200).body(instructorService.findById(id));
    }



}
