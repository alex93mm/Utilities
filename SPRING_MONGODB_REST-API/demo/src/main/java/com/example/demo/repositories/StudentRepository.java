package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StudentRepository
        extends MongoRepository<Student, String> {

    Optional<Student> findStudentByEmail(String email);
}
