package com.example.enicarthage.demo_proj_A.Services;

import com.example.enicarthage.demo_proj_A.Models.Certification;
import com.example.enicarthage.demo_proj_A.Repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    public List<Certification> getAllCertifications() {
        return certificationRepository.findAll();
    }

    public Optional<Certification> getCertificationById(Long id) {
        return certificationRepository.findById(id);
    }

    public Certification createCertification(Certification certification) {
        return certificationRepository.save(certification);
    }

    public Certification updateCertification(Long id, Certification updated) {
        updated.setId(id);
        return certificationRepository.save(updated);
    }

    public void deleteCertification(Long id) {
        certificationRepository.deleteById(id);
    }
}
