FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8082
ADD target/demo-0.0.1-SNAPSHOT.jar  /demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demo-0.0.1-SNAPSHOT.jar"]