# syntax=docker/dockerfile:1
FROM openjdk:16-alpine3.13 AS baseImage

LABEL image.author="Nikhil Kumar"

WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
EXPOSE 8080

FROM baseImage AS test
CMD ["./mvnw", "test"]

FROM baseImage AS development
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8080'"]

FROM baseImage AS build
CMD ./mvnw package

FROM openjdk:11-jre-slim AS production
COPY --from=build /app/target/student-service-*.jar /student-service.jar
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/student-service.jar"]