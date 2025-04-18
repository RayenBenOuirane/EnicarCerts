package com.example.enicarthage.demo_proj_A.DTO;


import lombok.Data;

@Data
public class ModuleDTO {
    private Long id;
    private String langue;
    private String niveau;
    private String semestre;
    private String seuilValidation;

    private Long specialiteId;
    private String specialiteNom;

    private int directionId;
    private String directionNom;
}
