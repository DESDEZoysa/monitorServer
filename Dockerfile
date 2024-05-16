FROM openjdk:17-alpine
WORKDIR /app
ARG JAR_FILE=target/monitorServer-0.0.1-SNAPSHOT.jar
COPY --from=builder $JAR_FILE /app/
COPY . .
RUN mvn clean package
EXPOSE 8091
ENTRYPOINT ["java", "-jar", "/app/$JAR_FILE"]
