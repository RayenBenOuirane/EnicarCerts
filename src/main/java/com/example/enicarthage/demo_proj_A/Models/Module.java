package com.example.enicarthage.demo_proj_A.Models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Module {
    @Id
    private String id;
    private String langue;
    private String niveau;
    private String semestre;
    private String seuilValidation;

    @ManyToOne
    @JoinColumn(name = "specialite_id")
    private Speciality specialite;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Direction direction;

    @ManyToMany(mappedBy = "modules")
    private List<Teacher> professeurs;
}
