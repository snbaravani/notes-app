package com.au.onefiremark.notes.config;

import com.au.onefiremark.notes.db.impl.NotesDBImpl;
import com.au.onefiremark.notes.db.interfaces.INotesDB;
import com.au.onefiremark.notes.db.interfaces.INotesRepository;
import com.au.onefiremark.notes.managers.impl.NotesManagerImpl;
import com.au.onefiremark.notes.managers.interfaces.INotesManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Subbu Baravani
 * Contains application configurations
 */
@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = {
        "com.au.onefiremark.notes.db.interfaces"})
@EntityScan("com.au.onefiremark.notes.db.entity")
public class ApplicationConfig {

       @Bean
       public INotesManager getNotesManager(){

              return new NotesManagerImpl();
       }

       @Bean
       public INotesDB getNotesDB() {
              return new NotesDBImpl();
       }
}
