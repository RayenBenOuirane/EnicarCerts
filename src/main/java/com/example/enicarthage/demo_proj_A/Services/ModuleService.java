package com.example.enicarthage.demo_proj_A.Services;


import com.example.enicarthage.demo_proj_A.Models.Module;
import com.example.enicarthage.demo_proj_A.Repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public List<Module> getAllModules() {
        return moduleRepository.findAll();
    }

    public Optional<Module> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    public Module createModule(Module module) {
        return moduleRepository.save(module);
    }

    public Module updateModule(Long id, Module updatedModule) {
        updatedModule.setId(id);
        return moduleRepository.save(updatedModule);
    }

    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
