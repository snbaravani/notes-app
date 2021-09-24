package com.au.onefiremark.notes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Subbu Baravani
 * Notes Application launch file
 *
 * Rest API's are avaialble at : http://localhost:8080/swagger-ui.html#

 * docker run -p 8080:8080  -it --volume  /Users/s115778/Documents/h2:/data notes-app:1.0
 */
@SpringBootApplication
@EnableSwagger2
public class NotesApplication  {
    private static Logger LOG = LoggerFactory.getLogger(NotesApplication.class);
    public static void main(String[] args) {
       LOG.info("Starting Notes Application !!!!");
        try {
            SpringApplication.run(NotesApplication. class , args);
        } catch ( Throwable e){
            LOG.error(e.getMessage());
        }
    }

    @PreDestroy
    void bye(){
        LOG.info( "Application is shutting down !");
    }

}
