package com.example.enicarthage.demo_proj_A.DTO;

import lombok.Data;

@Data
public class NoteDTO {
    private Long id;
    private String note;
    private String date;

    private int etudiantId;
    private String etudiantNom;
    private int professeurId;
    private String professeurNom;
}
