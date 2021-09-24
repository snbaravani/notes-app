package com.au.onefiremark.notes.util;

import com.au.onefiremark.notes.db.entity.NotesEntity;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

/**
 * @author Subbu Baravani
 * App level utitlity methods
 */
public class AppUtils {

    /**
     *
     * @param notes
     * @param clas
     * @return
     */
    public static Object convertToEntity(String notes, Class clas ){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Object entity = gsonBuilder.create().fromJson(notes,   clas);
        return entity;
    }

    /**
     *
     * @param notes
     * @return
     */
    public static List<NotesEntity> convertToEntityList(String notes){
        GsonBuilder gsonBuilder = new GsonBuilder();
        NotesEntity [] entity =   gsonBuilder.create().fromJson(notes,  NotesEntity[].class);
        return  Arrays.asList(entity);
    }

    /**
     *
     * @param object
     * @return
     */
    public static String convertToJson(Object object ){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return  gsonBuilder.create().toJson(object);
    }

    /**
     *
     * @param object
     * @return
     */
    public static String convertToJson(List<Object> object ){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return  gsonBuilder.create().toJson(object);
    }

}
