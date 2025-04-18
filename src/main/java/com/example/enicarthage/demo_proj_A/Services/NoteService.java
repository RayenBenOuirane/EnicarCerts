package com.example.enicarthage.demo_proj_A.Services;


import com.example.enicarthage.demo_proj_A.Models.Note;
import com.example.enicarthage.demo_proj_A.Repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    public Note updateNote(Long id, Note updatedNote) {
        updatedNote.setId(id);
        return noteRepository.save(updatedNote);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }
}
