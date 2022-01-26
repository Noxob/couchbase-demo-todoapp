FROM openjdk:8
COPY ./target/todoapp-0.0.1-SNAPSHOT.jar spring-boot.jar
CMD java -jar spring-boot.jar