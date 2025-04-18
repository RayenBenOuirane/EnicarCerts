package com.example.enicarthage.demo_proj_A.Controllers;
import com.example.enicarthage.demo_proj_A.DTO.LoginRequest;
import com.example.enicarthage.demo_proj_A.Models.Student;
import com.example.enicarthage.demo_proj_A.Repositories.DirectionRepository;
import com.example.enicarthage.demo_proj_A.Repositories.StudentRepository;
import com.example.enicarthage.demo_proj_A.Repositories.TeacherRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class LoginController {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private TeacherRepository teacherRepo;
    @Autowired
    private DirectionRepository directionRepo;

    @PostMapping("/student")
    public ResponseEntity<?> loginStudent(@Valid @RequestBody LoginRequest request) {
        return studentRepo.findByEmailAndMotDePasse(request.getEmail(), request.getPassword())
                .map(student -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Login success for Student");
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("error", "Invalid credentials");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                });
    }



    @PostMapping("/teacher")
    public ResponseEntity<?> loginTeacher(@Valid @RequestBody LoginRequest request) {
        return teacherRepo.findByEmailAndMotDePasse(request.getEmail(), request.getPassword())
                .map(student -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Login success for Teacher");
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("error", "Invalid credentials");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                });
    }

    @PostMapping("/direction")
    public ResponseEntity<?> loginDirection(@Valid @RequestBody LoginRequest request) {
        return directionRepo.findByEmailAndMotDePasse(request.getEmail(), request.getPassword())
                .map(student -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("message", "Login success for Admin");
                    return ResponseEntity.ok(response);
                })
                .orElseGet(() -> {
                    Map<String, String> response = new HashMap<>();
                    response.put("error", "Invalid credentials");
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
                });    }

}
