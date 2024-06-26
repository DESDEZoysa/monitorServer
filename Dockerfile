FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
RUN apt-get install maven -y 
COPY . .
RUN mvn clean install
FROM openjdk:19-jdk-slim
EXPOSE 8091
COPY --from=build /target/monitorServer-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
