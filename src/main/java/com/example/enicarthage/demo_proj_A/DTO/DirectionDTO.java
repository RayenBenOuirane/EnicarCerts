package com.example.enicarthage.demo_proj_A.DTO;


import lombok.Data;

@Data
public class DirectionDTO {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;


    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }
}
