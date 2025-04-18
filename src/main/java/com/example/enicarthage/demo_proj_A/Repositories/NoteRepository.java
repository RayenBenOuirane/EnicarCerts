package com.example.enicarthage.demo_proj_A.Repositories;

import com.example.enicarthage.demo_proj_A.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByProfesseurId(Long professeurId);

}
