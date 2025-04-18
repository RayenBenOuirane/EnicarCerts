package com.example.enicarthage.demo_proj_A.DTO;


import lombok.Data;
import java.util.List;

@Data
public class TeacherDTO {
    private int id;
    private String nom;
    private String prenom;
    private String email;

    private List<Long> classesIds;
    private List<Long> modulesIds;
    private List<Long> notesIds;
}
