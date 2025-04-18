package com.example.enicarthage.demo_proj_A.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.enicarthage.demo_proj_A.Models.Module;


public interface ModuleRepository extends JpaRepository<Module, Long> {
}
