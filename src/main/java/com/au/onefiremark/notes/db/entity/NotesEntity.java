package com.au.onefiremark.notes.db.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Notes entity
 */
@Entity(name = "Notes")
public class NotesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "content")
    private String content;

    @ElementCollection
    @Column(name = "tags")
    private List<String> tags;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }


}
