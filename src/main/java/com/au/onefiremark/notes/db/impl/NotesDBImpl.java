package com.au.onefiremark.notes.db.impl;

import com.au.onefiremark.notes.db.entity.NotesEntity;
import com.au.onefiremark.notes.db.interfaces.INotesDB;
import com.au.onefiremark.notes.db.interfaces.INotesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Subbu Baravani
 * Implements database actions on Notes entity @{@link NotesEntity}
 */
public class NotesDBImpl implements INotesDB {

    @Autowired
    private INotesRepository iNotesRepository;

    @Override
    public NotesEntity saveNotes(NotesEntity notes) {
        return iNotesRepository.save(notes);
    }

    @Override
    public Optional<NotesEntity> getNotes(Integer id) {
        return iNotesRepository.findById(id);
    }

    @Override
    public List<NotesEntity> getAllNotes() {
        return (List<NotesEntity>) iNotesRepository.findAll();
    }

    @Override
    public void deleteNote(Integer id) {
        iNotesRepository.deleteById(id);
    }

    @Override
    public ArrayList<String> getAllTags() {
        return iNotesRepository.findAllTags();
    }

    @Override
    public List<NotesEntity> getNotesForTag(String tag) {
        return iNotesRepository.findNotesByTag(tag);
    }

    @Override
    public void deleteAllNotes() {
        iNotesRepository.deleteAll();
    }
}
