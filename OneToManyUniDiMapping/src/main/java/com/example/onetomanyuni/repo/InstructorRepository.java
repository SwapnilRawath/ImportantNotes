package com.example.onetomanyuni.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetomanyuni.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

}
