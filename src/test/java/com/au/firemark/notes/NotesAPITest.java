package com.au.firemark.notes;

import com.au.onefiremark.notes.config.ApplicationConfig;
import com.au.onefiremark.notes.db.entity.NotesEntity;
import com.au.onefiremark.notes.managers.interfaces.INotesManager;
import com.au.onefiremark.notes.util.AppUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 * Test cases for all the APIs
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(
        classes = { TestBeanConfig.class ,  ApplicationConfig.class})
public class NotesAPITest {

    @Autowired
    private INotesManager notesManager;

    @Test
    public  void testCreateNote()  {
        String createdNote = notesManager.saveNotes(getNoteJson_1());
        NotesEntity entity  = (NotesEntity) AppUtils.convertToEntity(createdNote, NotesEntity.class);
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isGreaterThan(0);
        assertThat(entity.getTags().get(0)).isEqualTo("boring");
        assertThat(entity.getContent()).isEqualTo("Not funny anymore");

    }

    @Test
    public void testUpdateNote(){
        String createdNote = notesManager.saveNotes(getNoteJson_1());
        NotesEntity entity  = (NotesEntity) AppUtils.convertToEntity(createdNote, NotesEntity.class);
        entity.setContent("Updated content");
        String updated = AppUtils.convertToJson(entity);

        notesManager.updateNotes(updated,entity.getId());

        String result =  notesManager.getNotes(entity.getId());
        NotesEntity updatedEntity  = (NotesEntity) AppUtils.convertToEntity(result, NotesEntity.class);
        assertThat(updatedEntity).isNotNull();
        assertThat(updatedEntity.getId()).isEqualTo(entity.getId());
        assertThat(updatedEntity.getContent()).isEqualTo("Updated content");
        assertThat(updatedEntity.getTags().get(0)).isEqualTo("boring");
    }

    @Test
    public void testDeleteNote(){
        String createdNote = notesManager.saveNotes(getNoteJson_1());
        NotesEntity entity  = (NotesEntity) AppUtils.convertToEntity(createdNote, NotesEntity.class);
        assertThat(entity).isNotNull();
        assertThat(entity.getId()).isGreaterThan(0);
        notesManager.deleteNote(entity.getId());
        String result = notesManager.getNotes(entity.getId());
        assertThat(result).contains("Notes with id not " + entity.getId() + " found !");
    }

    @Test
    public void testDeleteAllNote(){
        notesManager.saveNotes(getNoteJson_1());
        notesManager.saveNotes(getNoteJson_2());
        String notes = notesManager.getAllNotes();
        List<NotesEntity> entityList  =   AppUtils.convertToEntityList(notes);
        assertThat(entityList.size()).isGreaterThan(1);
        notesManager.deleteAllNotes();
        notes = notesManager.getAllNotes();
        assertThat(notes).isNull();
    }

    @Test
    public void testGetATag(){
        notesManager.saveNotes(getNoteJson_1());
        notesManager.saveNotes(getNoteJson_2());
        String note =  notesManager.getNotesForTag("work");
        List<NotesEntity> entityList  =   AppUtils.convertToEntityList(note);
        assertThat(entityList).isNotNull();
        assertThat(entityList.get(0).getId()).isGreaterThan(0);
        assertThat(entityList.get(0).getContent()).isEqualTo("Good work");
    }

    @Test
    public void testGetAllTags(){
        notesManager.saveNotes(getNoteJson_1());
        notesManager.saveNotes(getNoteJson_2());
        ArrayList<String> tags =  notesManager.getAllTags();
        assertThat(tags).isNotNull();
        assertThat(tags.size()).isEqualTo(2);
        assertThat(tags.get(1)).isEqualTo("work");
    }

    @Test
    public void testFunny() {
        String joke = notesManager.getFunny();
        assertThat(joke).isNotNull();
        assertThat(joke.length()).isGreaterThan(20); // will be more than 20 chars
    }

    private String getNoteJson_1( ) {
       return  "{\n" +
                "  \"content\": \"Not funny anymore\",\n" +
                "  \"tags\": [\n" +
                "    \"boring\"\n" +
                "  ]\n" +
                "}";
    }

    private String getNoteJson_2( ) {
        return  "{\n" +
                "  \"content\": \"Good work\",\n" +
                "  \"tags\": [\n" +
                "    \"work\"\n" +
                "  ]\n" +
                "}";
    }

}
