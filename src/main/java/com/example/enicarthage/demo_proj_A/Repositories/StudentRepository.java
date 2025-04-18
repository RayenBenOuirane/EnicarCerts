package com.example.enicarthage.demo_proj_A.Repositories;

import com.example.enicarthage.demo_proj_A.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findByEmailAndMotDePasse(String email, String motDePasse);
}
