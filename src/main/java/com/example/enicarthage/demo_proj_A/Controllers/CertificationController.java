package com.example.enicarthage.demo_proj_A.Controllers;


import com.example.enicarthage.demo_proj_A.DTO.CertificationDTO;
import com.example.enicarthage.demo_proj_A.Models.Certification;
import com.example.enicarthage.demo_proj_A.Services.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/certifications")
public class CertificationController {

    @Autowired
    private CertificationService certificationService;

    // Créer une nouvelle certification
    @PostMapping
    public ResponseEntity<CertificationDTO> createCertification(@RequestBody CertificationDTO certificationDTO) {
        // Conversion du DTO vers le modèle Certification
        Certification certification = new Certification(
                certificationDTO.getId(),
                certificationDTO.getType(),
                certificationDTO.getScore(),
                certificationDTO.getStatut(),
                null, // On peut ajouter l'étudiant via un service ou un ID
                null  // On peut ajouter la direction via un service ou un ID
        );

        Certification createdCertification = certificationService.createCertification(certification);

        // Convertir la certification créée en DTO pour répondre
        CertificationDTO createdCertificationDTO = new CertificationDTO(
                createdCertification.getId(),
                createdCertification.getType(),
                createdCertification.getScore(),
                createdCertification.getStatut(),
                createdCertification.getEtudiant() != null ? createdCertification.getEtudiant().getId() : null,
                createdCertification.getDirection() != null ? createdCertification.getDirection().getId() : null
        );

        return ResponseEntity.ok(createdCertificationDTO);
    }

    // Récupérer toutes les certifications
    @GetMapping
    public List<CertificationDTO> getAllCertifications() {
        List<Certification> certifications = certificationService.getAllCertifications();

        return certifications.stream().map(certification -> new CertificationDTO(
                certification.getId(),
                certification.getType(),
                certification.getScore(),
                certification.getStatut(),
                certification.getEtudiant() != null ? certification.getEtudiant().getId() : null,
                certification.getDirection() != null ? certification.getDirection().getId() : null
        )).collect(Collectors.toList());
    }

    // Récupérer une certification par ID
    @GetMapping("/{id}")
    public ResponseEntity<CertificationDTO> getCertificationById(@PathVariable Long id) {
        Certification certification = certificationService.getCertificationById(id)
                .orElseThrow(() -> new RuntimeException("Certification non trouvée avec l'id: " + id));
        if (certification == null) {
            return ResponseEntity.notFound().build();
        }

        CertificationDTO certificationDTO = new CertificationDTO(
                certification.getId(),
                certification.getType(),
                certification.getScore(),
                certification.getStatut(),
                certification.getEtudiant() != null ? certification.getEtudiant().getId() : null,
                certification.getDirection() != null ? certification.getDirection().getId() : null
        );

        return ResponseEntity.ok(certificationDTO);
    }

    // Mettre à jour une certification
    @PutMapping("/{id}")
    public ResponseEntity<CertificationDTO> updateCertification(
            @PathVariable Long id,
            @RequestBody CertificationDTO certificationDTO
    ) {
        Certification certification = new Certification(
                certificationDTO.getId(),
                certificationDTO.getType(),
                certificationDTO.getScore(),
                certificationDTO.getStatut(),
                null, // On peut ajouter l'étudiant via un service ou un ID
                null  // On peut ajouter la direction via un service ou un ID
        );

        Certification updatedCertification = certificationService.updateCertification(id, certification);

        if (updatedCertification == null) {
            return ResponseEntity.notFound().build();
        }

        CertificationDTO updatedCertificationDTO = new CertificationDTO(
                updatedCertification.getId(),
                updatedCertification.getType(),
                updatedCertification.getScore(),
                updatedCertification.getStatut(),
                updatedCertification.getEtudiant() != null ? updatedCertification.getEtudiant().getId() : null,
                updatedCertification.getDirection() != null ? updatedCertification.getDirection().getId() : null
        );

        return ResponseEntity.ok(updatedCertificationDTO);
    }

    // Supprimer une certification
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.noContent().build();
    }
}
