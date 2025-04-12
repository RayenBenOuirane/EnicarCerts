package com.example.enicarthage.demo_proj_A.Controllers;

import com.example.enicarthage.demo_proj_A.DTO.LoginRequest;
import com.example.enicarthage.demo_proj_A.Repositories.DirectionRepository;
import com.example.enicarthage.demo_proj_A.Repositories.StudentRepository;
import com.example.enicarthage.demo_proj_A.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<?> loginStudent(@RequestBody LoginRequest request) {
        return studentRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .map(student -> ResponseEntity.ok("Login success for Student"))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
    }

    @PostMapping("/teacher")
    public ResponseEntity<?> loginTeacher(@RequestBody LoginRequest request) {
        return teacherRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .map(teacher -> ResponseEntity.ok("Login success for Teacher"))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
    }

    @PostMapping("/direction")
    public ResponseEntity<?> loginDirection(@RequestBody LoginRequest request) {
        return directionRepo.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .map(direction -> ResponseEntity.ok("Login success for Direction"))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
    }
}
