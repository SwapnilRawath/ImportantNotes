package com.example.onetomanyuni.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetomanyuni.model.Instructor;
import com.example.onetomanyuni.repo.InstructorRepository;

@RestController
@RequestMapping("/api/v1")
public class InstructorController {

    @Autowired
    private InstructorRepository instructorRepository;


    @GetMapping("/instructors")
    public List < Instructor > getInstructors() {
        return instructorRepository.findAll();
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity < Instructor > getInstructorById(
        @PathVariable(value = "id") Long instructorId) {
        Optional<Instructor> user = instructorRepository.findById(instructorId);
        
        return ResponseEntity.ok().body(user.get());
    }

    @PostMapping("/instructors")
    public Instructor createUser(@Valid @RequestBody Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    @PutMapping("/instructors/{id}")
    public ResponseEntity < Instructor > updateUser(
        @PathVariable(value = "id") Long instructorId,
        @Valid @RequestBody Instructor userDetails) {
        Optional<Instructor> user = instructorRepository.findById(instructorId);
        user.get().setEmail(userDetails.getEmail());
        final Instructor updatedUser = instructorRepository.save(user.get());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/instructors/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Long instructorId) {
    	Optional<Instructor> user = instructorRepository.findById(instructorId);
        
        instructorRepository.delete(user.get());
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
