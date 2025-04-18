package com.example.enicarthage.demo_proj_A.Controllers;

import com.example.enicarthage.demo_proj_A.DTO.ModuleDTO;
import com.example.enicarthage.demo_proj_A.Models.Module;
import com.example.enicarthage.demo_proj_A.Services.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/modules")
public class ModuleController {

    @Autowired
    private ModuleService moduleService;

    // Créer un module
    @PostMapping
    public Module createModule(@RequestBody Module module) {
        return moduleService.createModule(module);
    }

    // Récupérer tous les modules
    @GetMapping
    public List<Module> getAllModules() {
        return moduleService.getAllModules();
    }

    // Récupérer un module par ID
    @GetMapping("/{id}")
    public Optional<Module> getModuleById(@PathVariable Long id) {
        return moduleService.getModuleById(id);
    }

    // Mettre à jour un module
    @PutMapping("/{id}")
    public Module updateModule(@PathVariable Long id, @RequestBody Module updatedModule) {
        return moduleService.updateModule(id, updatedModule);
    }

    // Supprimer un module
    @DeleteMapping("/{id}")
    public void deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
    }
}
