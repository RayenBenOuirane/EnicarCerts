package com.example.enicarthage.demo_proj_A.Services;


import com.example.enicarthage.demo_proj_A.DTO.DirectionDTO;
import com.example.enicarthage.demo_proj_A.Models.Direction;
import com.example.enicarthage.demo_proj_A.Models.SchoolClass;
import com.example.enicarthage.demo_proj_A.Models.Speciality;
import com.example.enicarthage.demo_proj_A.Repositories.DirectionRepository;
import com.example.enicarthage.demo_proj_A.Repositories.SchoolClassRepository;
import com.example.enicarthage.demo_proj_A.Repositories.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DirectionService {

    private final DirectionRepository directionRepository;
    private final SchoolClassRepository schoolClassRepository;
    private final SpecialityRepository specialityRepository;

    @Autowired
    public DirectionService(DirectionRepository directionRepository,
                            SchoolClassRepository schoolClassRepository,
                            SpecialityRepository specialityRepository) {
        this.directionRepository = directionRepository;
        this.schoolClassRepository = schoolClassRepository;
        this.specialityRepository = specialityRepository;
    }

    public List<DirectionDTO> getAllDirections() {
        return directionRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public DirectionDTO getDirectionById(Long id) {
        Direction direction = directionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        return convertToDTO(direction);
    }

    @Transactional
    public DirectionDTO createDirection(DirectionDTO directionDTO) {
        Direction direction = new Direction();
        direction.setNom(directionDTO.getNom());
        direction.setPrenom(directionDTO.getPrenom());
        direction.setEmail(directionDTO.getEmail());
        direction.setMotDePasse(directionDTO.getMotDePasse());

        direction = directionRepository.save(direction);
        return convertToDTO(direction);
    }

    @Transactional
    public DirectionDTO updateDirection(Long id, DirectionDTO directionDTO) {
        Direction direction = directionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        direction.setNom(directionDTO.getNom());
        direction.setPrenom(directionDTO.getPrenom());
        direction.setEmail(directionDTO.getEmail());
        direction.setMotDePasse(directionDTO.getMotDePasse());

        direction = directionRepository.save(direction);
        return convertToDTO(direction);
    }

    @Transactional
    public void deleteDirection(Long id) {
        Direction direction = directionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        directionRepository.delete(direction);
    }

    public List<SchoolClass> getClassesByDirection(Long directionId) {
        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        return schoolClassRepository.findByDirection(direction);
    }

    public List<Speciality> getSpecialitiesByDirection(Long directionId) {
        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        return specialityRepository.findByDirection(direction);
    }

    @Transactional
    public SchoolClass createSchoolClass(Long directionId, SchoolClass schoolClass) {
        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        schoolClass.setDirection(direction);
        return schoolClassRepository.save(schoolClass);
    }

    @Transactional
    public Speciality createSpeciality(Long directionId, Speciality speciality) {
        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée"));
        speciality.setDirection(direction);
        return specialityRepository.save(speciality);
    }

    private DirectionDTO convertToDTO(Direction direction) {
        DirectionDTO directionDTO = new DirectionDTO();
        directionDTO.setId(direction.getId());
        directionDTO.setNom(direction.getNom());
        directionDTO.setPrenom(direction.getPrenom());
        directionDTO.setEmail(direction.getEmail());
        return directionDTO;
    }
}
