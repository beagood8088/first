FROM openjdk:8-jdk-alpine
MAINTAINER xxx.com
COPY target/first-0.0.1-SNAPSHOT.jar notification-server-1.0.0.jar
ENTRYPOINT ["java","-jar","/notification-server-1.0.0.jar"]