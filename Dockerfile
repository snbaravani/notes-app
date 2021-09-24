FROM openjdk:11

ADD target/notes-app-1.0.jar /opt/microservice/notes.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java -jar  /opt/microservice/notes.jar"]

