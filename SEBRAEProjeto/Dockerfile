FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY . .

RUN chmod +x mvnw && ./mvnw clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

COPY --from=build /app/src/main/resources/data ./src/main/resources/data
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]