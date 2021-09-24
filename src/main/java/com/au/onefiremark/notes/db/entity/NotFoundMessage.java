package com.au.onefiremark.notes.db.entity;

/**
 * Holds Notes Not Found Error message
 */
public class NotFoundMessage {

    private String message;

    private Integer id;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
