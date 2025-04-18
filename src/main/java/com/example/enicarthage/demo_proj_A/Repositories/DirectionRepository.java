package com.example.enicarthage.demo_proj_A.Repositories;

import com.example.enicarthage.demo_proj_A.Models.Direction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DirectionRepository extends JpaRepository<Direction, Long> {
    Optional<Direction> findByEmailAndMotDePasse(String email, String motDePasse);
}