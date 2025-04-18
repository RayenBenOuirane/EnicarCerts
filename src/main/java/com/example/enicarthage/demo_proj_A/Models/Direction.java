package com.example.enicarthage.demo_proj_A.Models;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "direction")
public class Direction {
    @Id
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    @Column(name = "mot_de_passe")
    private String motDePasse;

    @OneToMany(mappedBy = "direction")
    private List<SchoolClass> classes;

    @OneToMany(mappedBy = "direction")
    private List<Speciality> specialites;

    @OneToMany(mappedBy = "direction")
    private List<Module> modules;

    @OneToMany(mappedBy = "direction")
    private List<Certification> certifications;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<SchoolClass> getClasses() {
        return classes;
    }

    public void setClasses(List<SchoolClass> classes) {
        this.classes = classes;
    }

    public List<Speciality> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(List<Speciality> specialites) {
        this.specialites = specialites;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }
}
