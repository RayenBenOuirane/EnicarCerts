package com.example.enicarthage.demo_proj_A.Controllers;

import com.example.enicarthage.demo_proj_A.DTO.SpecialityDTO;
import com.example.enicarthage.demo_proj_A.Models.Speciality;
import com.example.enicarthage.demo_proj_A.Services.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/specialities")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    // Créer une spécialité
    @PostMapping
    public Speciality createSpeciality(@RequestBody Speciality speciality) {
        return specialityService.createSpeciality(speciality);
    }

    // Récupérer toutes les spécialités
    @GetMapping
    public List<Speciality> getAllSpecialities() {
        return specialityService.getAllSpecialities();
    }

    // Récupérer une spécialité par ID
    @GetMapping("/{id}")
    public Optional<Speciality> getSpecialityById(@PathVariable Long id) {
        return specialityService.getSpecialityById(id);
    }

    // Mettre à jour une spécialité
    @PutMapping("/{id}")
    public Speciality updateSpeciality(@PathVariable Long id, @RequestBody Speciality updatedSpeciality) {
        return specialityService.updateSpeciality(id, updatedSpeciality);
    }

    // Supprimer une spécialité
    @DeleteMapping("/{id}")
    public void deleteSpeciality(@PathVariable Long id) {
        specialityService.deleteSpeciality(id);
    }
}
