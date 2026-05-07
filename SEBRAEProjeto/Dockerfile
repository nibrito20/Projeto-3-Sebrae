FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

COPY --from=build /app/src/main/resources/data ./src/main/resources/data

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]