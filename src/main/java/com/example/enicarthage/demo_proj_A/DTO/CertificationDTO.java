package com.example.enicarthage.demo_proj_A.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CertificationDTO {

    private Long id;
    private String type;
    private String score;
    private String statut;
    private Long etudiantId;     // ID de l'étudiant
    private Long directionId;    // ID de la direction


}

