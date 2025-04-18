package com.example.enicarthage.demo_proj_A.DTO;


import lombok.Data;

@Data
public class SchoolClassDTO {
    private Long id;
    private String nom;
    private String annee;

    private Integer directionId;
    private String directionNom;

    private Long professeurId;
    private String professeurNom;
}
