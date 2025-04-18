package com.example.enicarthage.demo_proj_A.Services;


import com.example.enicarthage.demo_proj_A.Models.Speciality;
import com.example.enicarthage.demo_proj_A.Repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialityService {

    @Autowired
    private SpecialityRepository specialityRepository;

    public List<Speciality> getAllSpecialities() {
        return specialityRepository.findAll();
    }

    public Optional<Speciality> getSpecialityById(Long id) {
        return specialityRepository.findById(id);
    }

    public Speciality createSpeciality(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    public Speciality updateSpeciality(Long id, Speciality updated) {
        updated.setId(id);
        return specialityRepository.save(updated);
    }

    public void deleteSpeciality(Long id) {
        specialityRepository.deleteById(id);
    }
}
