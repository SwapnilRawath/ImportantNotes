package com.example.onetooneuni.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetooneuni.model.Instructor;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
