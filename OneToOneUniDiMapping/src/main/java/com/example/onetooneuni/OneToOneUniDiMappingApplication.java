package com.example.onetooneuni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.onetooneuni.model.Instructor;
import com.example.onetooneuni.model.InstructorDetail;
import com.example.onetooneuni.repo.InstructorRepository;

@SpringBootApplication
public class OneToOneUniDiMappingApplication {

	public static void main(String[] args) {
        SpringApplication.run(OneToOneUniDiMappingApplication.class, args);
    }

    @Autowired
    private InstructorRepository instructorRepository;

    public void run(String...args) throws Exception {

        Instructor instructor = new Instructor("Swapnil", "Rawath", "swapnil.rawath@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("Java Guides", "Cricket Playing");

        // associate the objects
        instructor.setInstructorDetail(instructorDetail);

        instructorRepository.save(instructor);
    }

}
