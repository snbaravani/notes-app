package com.au.onefiremark.notes.managers.interfaces;

import java.util.ArrayList;

public interface INotesManager {

    /**
     * SAve notes in  the datastoer
     * @param notes
     * @return
     */
    String saveNotes(String notes);

    /**
     * Retrieve notes
     * @param id
     * @return
     */
    String getNotes(Integer id);

    /**
     * Get all notes from the system
     * @return
     */
    String getAllNotes();

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
    String getNotesForTag(String tag);

    /**
     *
     * @param notes
     * @param id
     * @return
     */
    String updateNotes(String notes, int id);

    /**
     * Delete all notes in the system
     */
    void deleteAllNotes();

    String getFunny();
}
