package com.au.onefiremark.notes.endpoints;

import com.au.onefiremark.notes.managers.interfaces.INotesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Subbu Baravani
 * All the Rest end points go here
 */

@RestController
@RequestMapping("/v1")
public class NotesEndPointImpl {
    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private INotesManager notesManager;

    /*********** Create methods ***********/
    @RequestMapping(value = "note",method = RequestMethod.POST)
    public String createNotes(@RequestParam   String notes){
        LOG.info("createNotes {}" , notes);
        return notesManager.saveNotes(notes);
    }

    @RequestMapping(value = "note/{id}",method = RequestMethod.PUT)
    public String updateNote(@PathVariable int id, @RequestParam   String notes ){
        LOG.info("updateNote {}" , notes);
        return notesManager.updateNotes(notes, id);
    }

    /********* Get Methods *******/
    @RequestMapping(value = "note/{id}",method = RequestMethod.GET)
    public String getNotes(@PathVariable Integer id){
        LOG.info("getNotes {}" , id);
        return notesManager.getNotes(id);
    }

    @RequestMapping(value = "note",method = RequestMethod.GET)
    public String getAllNotes(){
        LOG.info("getAllNotes ");
        return notesManager.getAllNotes();
    }

    /********* Delete methods *********/
    @RequestMapping(value = "note/{id}",method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable int id ){
        notesManager.deleteNote(id);
    }

    @RequestMapping(value = "note",method = RequestMethod.DELETE)
    public void deleteAllNotes(){
        LOG.info("deleteAllNotes ");
        notesManager.deleteAllNotes();
    }

    /***** Tag related methods ************/
    @RequestMapping(value = "tags",method = RequestMethod.GET)
    public ArrayList<String> getAllTags(){
        LOG.info("getAllTags ");
        return notesManager.getAllTags();
    }

    @RequestMapping(value = "tags/{tag}",method = RequestMethod.GET)
    public String  getNotesWithTag(@PathVariable String tag){
        LOG.info("getNotesWithTag");
        return notesManager.getNotesForTag(tag);
    }

    @RequestMapping(value = "note/funny",method = RequestMethod.GET)
    public String  getFunny( ){
        LOG.info("getFunny");
        return notesManager.getFunny();
    }
}
