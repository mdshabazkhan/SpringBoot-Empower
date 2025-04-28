# Use a working Maven image
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Copy project files
COPY . .

# Build the project
RUN mvn clean package -DskipTests

# Now use a lightweight JDK for running the app
FROM openjdk:21-jdk-slim

# Copy the generated jar from the build stage
COPY --from=build /target/employee-rating-system-0.0.1-SNAPSHOT.jar employee-rating-system.jar

# Expose the port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "employee-rating-system.jar"]
