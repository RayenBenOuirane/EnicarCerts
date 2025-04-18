package com.example.enicarthage.demo_proj_A.DTO;


import com.example.enicarthage.demo_proj_A.Models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String annee;
    private String email;

    private Long classeId;
    private String classeNom;

    private Long specialiteId;
    private String specialiteNom;
    public StudentDTO convertToDTO(Student student) {
        if (student == null) return null;

        return new StudentDTO(
                student.getId(),
                student.getNom(),
                student.getPrenom(),
                student.getAnnee(),
                student.getEmail(),
                student.getClasse() != null ? student.getClasse().getId() : 0,
                student.getClasse() != null ? student.getClasse().getNom() : null,
                student.getSpecialite() != null ? student.getSpecialite().getId() : 0,
                student.getSpecialite() != null ? student.getSpecialite().getNom() : null
        );
    }

}

