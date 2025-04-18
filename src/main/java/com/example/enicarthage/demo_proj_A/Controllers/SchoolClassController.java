package com.example.enicarthage.demo_proj_A.Controllers;


import com.example.enicarthage.demo_proj_A.Models.SchoolClass;
import com.example.enicarthage.demo_proj_A.Services.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classes")
public class SchoolClassController {

    private final SchoolClassService schoolClassService;

    @Autowired
    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @GetMapping
    public List<SchoolClass> getAllClasses() {
        return schoolClassService.getAllClasses();
    }

    @GetMapping("/{id}")
    public SchoolClass getClassById(@PathVariable Long id) {
        return schoolClassService.getClassById(id);
    }

    @PostMapping
    public SchoolClass createClass(@RequestBody SchoolClass schoolClass,
                                   @RequestParam Long directionId,
                                   @RequestParam Long teacherId) {
        return schoolClassService.createClass(schoolClass, directionId, teacherId);
    }

    @PutMapping("/{id}")
    public SchoolClass updateClass(@PathVariable Long id,
                                   @RequestBody SchoolClass updatedClass,
                                   @RequestParam Long directionId,
                                   @RequestParam Long teacherId) {
        return schoolClassService.updateClass(id, updatedClass, directionId, teacherId);
    }

    @DeleteMapping("/{id}")
    public void deleteClass(@PathVariable Long id) {
        schoolClassService.deleteClass(id);
    }

    @GetMapping("/by-direction/{directionId}")
    public List<SchoolClass> getClassesByDirection(@PathVariable Long directionId) {
        return schoolClassService.getClassesByDirection(directionId);
    }
}

