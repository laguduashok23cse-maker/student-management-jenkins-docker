# Student Management System

A beginner full-stack Java project for practising Maven, Jenkins, Docker and MySQL.

## Requirements
- Java 21
- Maven 3.8+
- Docker Engine and Docker Compose plugin
- Git

## Run locally with Maven
Start a MySQL server and create a database named `studentdb`, then run:
```bash
mvn clean package
mvn spring-boot:run
```
Open http://localhost:8080

The default local database settings are in `src/main/resources/application.properties`. Override them with environment variables if needed.

## Run using Docker Compose
```bash
mvn clean package
docker compose up -d --build
docker compose ps
```
Open http://localhost:8080

Stop containers:
```bash
docker compose down
```
Stop and delete database data too (destructive):
```bash
docker compose down -v
```

## Jenkins
1. Push this project to a GitHub repository.
2. In Jenkins, install/configure the Pipeline, Git and Maven/JDK tools as needed.
3. Ensure the Jenkins agent can run `mvn` and `docker compose` and has permission to access the Docker daemon.
4. Create a **Pipeline** job, select **Pipeline script from SCM**, choose Git, enter your repository URL, and set Script Path to `Jenkinsfile`.
5. Run Build Now. After success, open http://localhost:8080.

If Jenkins runs inside WSL, Docker access must be configured for the same environment/agent that runs the pipeline. Do not assume Docker installed in Windows is automatically available inside the Jenkins environment.

## Notes
- This is a learning project. The sample database credentials are for local practice only; change them before any real deployment.
- The app uses Spring Data JPA `ddl-auto=update` to create/update the `student` table automatically.
- For production, add authentication, validation, CSRF protection, database migrations and secrets management.
