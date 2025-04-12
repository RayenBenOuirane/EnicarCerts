package com.example.enicarthage.demo_proj_A.Models;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Direction {
    @Id
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String password;

    @OneToMany(mappedBy = "direction")
    private List<SchoolClass> classes;

    @OneToMany(mappedBy = "direction")
    private List<Speciality> specialites;

    @OneToMany(mappedBy = "direction")
    private List<Module> modules;

    @OneToMany(mappedBy = "direction")
    private List<Certification> certifications;
}
