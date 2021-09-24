
This project builds and exposes 8 APIs [http://localhost:8080/v1/note]

1. Create a note
2. Update a note
3. Get a note
4. Get all notes in the system
5. Delete a a note
6. Delete all notes
7. Get a tag
8. Get all tags
9. Get a funny note from Chuck Norris 

All the APIs can be accessed after docker runs at : http://localhost:8080/swagger-ui.html#/

API Documentation is available at : http://localhost:8080/v2/api-docs

**Test reports will be available at**: code_base/target/site/surefire-report.html


**Technologies used:**

Progaramming language: Java 11

Framework: Spring Boot

Build Tool: Maven 3.x

Database: H2

**System Requirement**:
For building and running the application you need: Java 11, Docker, Maven 3.x

**Build Command:** 
mvn clean install site

Please create directory on the host ex: /Users/s115778/Documents/h2. This directory will hold the notes database
and please provide read/write perm i.e chmod 777 direName. This helps to save the data after docker re-starts.

**Running the app**: docker run -p 8080:8080  -it --volume  /Users/s115778/Documents/h2:/data notes-app:1.0

notes-app:1.0 : is the docker image name created by the maven command

8080 : Port on which the app is accessible on host's machine

data: Directory inside docker that holds the H2 database data



