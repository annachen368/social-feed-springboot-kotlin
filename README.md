Kotlin Spring Boot Social Feed Demo

This is a demo project to practice REST API development using Spring Boot and Kotlin.

To run:

1. Start PostgreSQL:
   brew services start postgresql
   psql postgres
   CREATE DATABASE socialfeed;

2. Update database settings in src/main/resources/application.properties:
   spring.datasource.username=your_postgres_username
   spring.datasource.password=your_password_or_blank

3. Run the app:
   ./mvnw spring-boot:run

App will start at: http://localhost:8080
