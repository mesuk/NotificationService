FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} notification-service.jar
EXPOSE 6060-6060

ENTRYPOINT ["java","-jar","/notification-service.jar"]