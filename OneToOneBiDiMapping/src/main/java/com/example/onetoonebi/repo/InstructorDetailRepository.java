package com.example.onetoonebi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onetoonebi.model.InstructorDetail;

@Repository
public interface InstructorDetailRepository extends JpaRepository<InstructorDetail, Long> {

}
