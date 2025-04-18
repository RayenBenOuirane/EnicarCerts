package com.example.enicarthage.demo_proj_A.Services;


import com.example.enicarthage.demo_proj_A.Models.Direction;
import com.example.enicarthage.demo_proj_A.Models.SchoolClass;
import com.example.enicarthage.demo_proj_A.Models.Teacher;
import com.example.enicarthage.demo_proj_A.Repositories.DirectionRepository;
import com.example.enicarthage.demo_proj_A.Repositories.SchoolClassRepository;
import com.example.enicarthage.demo_proj_A.Repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolClassService {

    private final SchoolClassRepository schoolClassRepository;
    private final DirectionRepository directionRepository;
    private final TeacherRepository teacherRepository;

    @Autowired
    public SchoolClassService(SchoolClassRepository schoolClassRepository,
                              DirectionRepository directionRepository,
                              TeacherRepository teacherRepository) {
        this.schoolClassRepository = schoolClassRepository;
        this.directionRepository = directionRepository;
        this.teacherRepository = teacherRepository;
    }

    public List<SchoolClass> getAllClasses() {
        return schoolClassRepository.findAll();
    }

    public SchoolClass getClassById(Long id) {
        return schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec ID: " + id));
    }

    public SchoolClass createClass(SchoolClass schoolClass, Long directionId, Long teacherId) {
        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée avec ID: " + directionId));

        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec ID: " + teacherId));

        schoolClass.setDirection(direction);
        schoolClass.setProfesseur(teacher);

        return schoolClassRepository.save(schoolClass);
    }

    public SchoolClass updateClass(Long id, SchoolClass updatedClass, Long directionId, Long teacherId) {
        SchoolClass existingClass = schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec ID: " + id));

        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée avec ID: " + directionId));

        Teacher teacher = teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Enseignant non trouvé avec ID: " + teacherId));

        existingClass.setNom(updatedClass.getNom());
        existingClass.setAnnee(updatedClass.getAnnee());
        existingClass.setDirection(direction);
        existingClass.setProfesseur(teacher);

        return schoolClassRepository.save(existingClass);
    }

    public void deleteClass(Long id) {
        SchoolClass schoolClass = schoolClassRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Classe non trouvée avec ID: " + id));

        schoolClassRepository.delete(schoolClass);
    }

    public List<SchoolClass> getClassesByDirection(Long directionId) {
        Direction direction = directionRepository.findById(directionId)
                .orElseThrow(() -> new RuntimeException("Direction non trouvée avec ID: " + directionId));
        return schoolClassRepository.findByDirection(direction);
    }
}
