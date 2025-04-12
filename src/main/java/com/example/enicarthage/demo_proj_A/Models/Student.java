package com.example.enicarthage.demo_proj_A.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "student")
public class Student {
    @Id
    private int id;
    private String nom;
    private String prenom;
    private String annee;
    private String password;
    private String email;
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private SchoolClass classe;

    @ManyToOne
    @JoinColumn(name = "specialite_id")
    private Speciality specialite;

    @OneToMany(mappedBy = "etudiant")
    private List<Note> notes;

    @OneToMany(mappedBy = "etudiant")
    private List<Certification> certifications;
}
