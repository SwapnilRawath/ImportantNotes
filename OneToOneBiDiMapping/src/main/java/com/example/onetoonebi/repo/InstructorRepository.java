package com.example.onetoonebi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoonebi.model.Instructor;


@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}
