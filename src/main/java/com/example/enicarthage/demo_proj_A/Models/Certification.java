package com.example.enicarthage.demo_proj_A.Models;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Certification {
    @Id
    private String id;
    private String type;
    private String score;
    private String statut;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Student etudiant;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;
}
