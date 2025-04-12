package com.example.enicarthage.demo_proj_A.Models;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolClass {
    @Id
    private int id;
    private String nom;
    private String annee;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Teacher professeur;

    @OneToMany(mappedBy = "classe")
    private List<Student> etudiants;
}
