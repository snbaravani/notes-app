package com.au.onefiremark.notes.db.interfaces;

import com.au.onefiremark.notes.db.entity.NotesEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Subbu Baravani
 * CRUD Repository
 */
@Repository
public interface INotesRepository extends CrudRepository<NotesEntity, Integer> {
    @Query(value = "SELECT * from Notes where id in ( Select notes_id from Notes_Tags where tags LIKE  :tag) ",
            nativeQuery = true
    )
    List<NotesEntity> findNotesByTag( String tag  );

    @Query(value = "SELECT DISTINCT  tags from Notes_Tags",
            nativeQuery = true
    )
    ArrayList<String> findAllTags( );


}
