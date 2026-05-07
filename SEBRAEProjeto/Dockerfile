FROM eclipse-temurin:17-jdk-alpine
COPY . .
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/*.jar"]