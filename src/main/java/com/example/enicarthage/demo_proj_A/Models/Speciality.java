package com.example.enicarthage.demo_proj_A.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Speciality {
    @Id
    private Long id;
    private String nom;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @OneToMany(mappedBy = "specialite")
    private List<Student> etudiants;

    @OneToMany(mappedBy = "specialite")
    private List<Module> modules;
}

