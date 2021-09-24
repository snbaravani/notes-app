package com.au.onefiremark.notes.managers.impl;

import com.au.onefiremark.notes.db.entity.NotFoundMessage;
import com.au.onefiremark.notes.db.entity.NotesEntity;
import com.au.onefiremark.notes.db.interfaces.INotesDB;
import com.au.onefiremark.notes.managers.interfaces.INotesManager;
import com.au.onefiremark.notes.util.ExternalAPIUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.au.onefiremark.notes.util.AppUtils.*;
import static com.au.onefiremark.notes.util.AppUtils.convertToJson;

/**
 * @author Subbu Baravani
 * Implementers of Notes actions. Please use these methods instead of calling
 * DB methods directly
 */
@Transactional
public class NotesManagerImpl implements INotesManager {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private INotesDB notesDB;

    /**
     *
     * @param notes
     * @return
     */
    @Override
    public String saveNotes(String notes) {
        LOG.info("start:: saveNotes");
        NotesEntity notesEntity = notesDB.saveNotes((NotesEntity) convertToEntity(notes, NotesEntity.class));
        return convertToJson(notesEntity);
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public String getNotes(Integer id) {
        LOG.info("start:: getNotes");
        Optional<NotesEntity> notesEntity = notesDB.getNotes(id);
        if (notesEntity != null && notesEntity.isPresent()) {
            return convertToJson(notesEntity.get());
        } else {
            NotFoundMessage notFoundMessage = new NotFoundMessage();
            notFoundMessage.setMessage("Notes with id not " + id + " found !");
            notFoundMessage.setId(id);
            return convertToJson(notFoundMessage);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public String getAllNotes() {
        LOG.info("start:: getAllNotes");
        List<NotesEntity> entityList = notesDB.getAllNotes();
        if (entityList != null && entityList.size() > 0) {
            return convertToJson(entityList);
        }
        return null;
    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteNote(Integer id) {
        LOG.info("start:: deleteNote");
        notesDB.deleteNote(id);

    }

    /**
     *
     * @return
     */
    @Override
    public ArrayList<String> getAllTags() {
        LOG.info("start:: getAllTags");
        return notesDB.getAllTags();
    }

    /**
     *
     * @param tag
     * @return
     */
    @Override
    public String getNotesForTag(String tag) {
        List<NotesEntity> entityList = notesDB.getNotesForTag(tag);
        LOG.info("start:: getNotesForTag");
        if (entityList != null && entityList.size() > 0) {
            return convertToJson(entityList);
        }
        return "No notes found in the system";
    }

    /**
     *
     * @param notes
     * @param id
     * @return
     */
    @Override
    public String updateNotes(String notes, int id) {
        LOG.info("start:: updateNotes");
       NotesEntity notesEntity = (NotesEntity) convertToEntity(notes, NotesEntity.class);
       notesEntity.setId(id);
       notesEntity= notesDB.saveNotes(notesEntity);
        return convertToJson(notesEntity);
    }

    /**
     *
     */
    @Override
    public void deleteAllNotes() {
        LOG.info("start:: deleteAllNotes");
        notesDB.deleteAllNotes();
    }

    @Override
    public String getFunny() {
        return ExternalAPIUtil.getChuckNorrisJoke();
    }
}
