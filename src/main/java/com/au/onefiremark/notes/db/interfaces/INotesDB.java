package com.au.onefiremark.notes.db.interfaces;

import com.au.onefiremark.notes.db.entity.NotesEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface INotesDB {
    /**
     * SAve notes in  the datastoer
     * @param notes
     * @return
     */
     NotesEntity saveNotes(NotesEntity notes);

    /**
     * Retrieve notes
     * @param id
     * @return
     */
     Optional<NotesEntity> getNotes(Integer id);

    /**
     * Get all notes from the system
     * @return
     */
     List<NotesEntity> getAllNotes();

    /**
     * Deleete a note
     * @param id
     */
     void deleteNote(Integer id);

    /**
     *Get all the tags stored in the system
     * @return
     */
     ArrayList<String> getAllTags();

    /**
     * Get all the notes with the same tag
     * @param tag
     * @return
     */
     List<NotesEntity> getNotesForTag(String tag);

    /**
     * Delete all notes from the system
     */
    void deleteAllNotes();
}
