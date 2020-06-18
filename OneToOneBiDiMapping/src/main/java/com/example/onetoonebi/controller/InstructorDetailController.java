package com.example.onetoonebi.controller;

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

import com.example.onetoonebi.model.InstructorDetail;
import com.example.onetoonebi.repo.InstructorDetailRepository;

@RestController
@RequestMapping("/api/v1")
public class InstructorDetailController {
	@Autowired
    private InstructorDetailRepository instructorDetailRepository;


    @GetMapping("/instructorsDetail")
    public List < InstructorDetail > getInstructors() {
        return instructorDetailRepository.findAll();
    }

    @GetMapping("/instructorsDetail/{id}")
    public ResponseEntity < InstructorDetail > getInstructorById(
        @PathVariable(value = "id") Long instructorId) {
        Optional<InstructorDetail> user = instructorDetailRepository.findById(instructorId);
        
        return ResponseEntity.ok().body(user.get());
    }

    @PostMapping("/instructorsDetail")
    public InstructorDetail createUser(@Valid @RequestBody InstructorDetail instructor) {
        return instructorDetailRepository.save(instructor);
    }

    @PutMapping("/instructorsDetail/{id}")
    public ResponseEntity < InstructorDetail > updateUser(
        @PathVariable(value = "id") Long instructorId,
        @Valid @RequestBody InstructorDetail userDetails) {
        Optional<InstructorDetail> user = instructorDetailRepository.findById(instructorId);
        user.get().setHobby(userDetails.getHobby());
        final InstructorDetail updatedUser = instructorDetailRepository.save(user.get());
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/instructorsDetail/{id}")
    public Map < String, Boolean > deleteUser(
        @PathVariable(value = "id") Long instructorId) {
    	Optional<InstructorDetail> user = instructorDetailRepository.findById(instructorId);
        
    	instructorDetailRepository.delete(user.get());
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
