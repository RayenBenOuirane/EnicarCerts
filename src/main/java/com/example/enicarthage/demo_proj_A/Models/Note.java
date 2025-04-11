package com.example.enicarthage.demo_proj_A.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note {
    @Id
    private String id;
    private String note;
    private String date;

    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Student etudiant;

    @ManyToOne
    @JoinColumn(name = "professeur_id")
    private Teacher professeur;
}
