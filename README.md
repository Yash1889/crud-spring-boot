# Spring Boot CRUD Example with Thymeleaf and H2

This is a simple Spring Boot application demonstrating CRUD (Create, Read, Update, Delete) operations on a `Student` entity. It uses Spring Data JPA, Thymeleaf for the frontend, and an H2 in-memory database.

## Project Structure

- `pom.xml`: Maven project configuration and dependencies.
- `src/main/java/com/example/crudspringboot`:
  - `CrudSpringBootApplication.java`: Main Spring Boot application class.
  - `model/Student.java`: JPA entity for Student.
  - `repository/StudentRepository.java`: Spring Data JPA repository interface.
  - `service/StudentService.java` & `StudentServiceImpl.java`: Service layer for business logic.
  - `controller/StudentController.java`: Spring MVC controller for handling web requests.
- `src/main/resources`:
  - `application.properties`: Application configuration (H2 database, JPA, Thymeleaf).
  - `templates/`: Thymeleaf HTML templates.
    - `students.html`: Lists all students.
    - `add-student.html`: Form to add a new student.
    - `edit-student.html`: Form to edit an existing student.
    - `fragments.html`: Common UI fragments (header, navbar, footer).

## Prerequisites

- Java JDK 17 or later.
- Apache Maven (if running from command line without the wrapper).
- An IDE like Spring Tool Suite (STS), IntelliJ IDEA, or Eclipse (with Spring Tools plugin) is recommended.

## How to Run

### 1. Using an IDE (Recommended)

1.  Open your IDE (STS, IntelliJ IDEA, Eclipse).
2.  Import the project:
    - File -> Import -> Maven -> Existing Maven Projects.
    - Select the root directory of this project (`/home/yashraj/CRUD SPRING BOOT/`).
3.  Once the project is imported and dependencies are resolved, locate the `CrudSpringBootApplication.java` file.
4.  Right-click on `CrudSpringBootApplication.java` and select "Run As" -> "Spring Boot App".

### 2. Using Command Line (Maven Required)

1.  **Install Apache Maven**: If you don't have Maven installed, download it from [maven.apache.org](https://maven.apache.org/download.cgi) and follow the installation instructions for your OS.
2.  **Open a terminal or command prompt.**
3.  **Navigate to the project's root directory**:
    ```bash
    cd "/home/yashraj/CRUD SPRING BOOT/"
    ```
4.  **(Optional but Recommended) Generate Maven Wrapper**:
    If the Maven wrapper (`mvnw`) is not present, you can generate it (requires Maven to be installed):
    ```bash
    mvn wrapper:wrapper
    ```
    This will create `mvnw` (for Linux/macOS) and `mvnw.cmd` (for Windows) scripts.

5.  **Run the application**:
    - If you generated the wrapper:
      ```bash
      ./mvnw spring-boot:run
      ```
    - If using your global Maven installation:
      ```bash
      mvn spring-boot:run
      ```

### 3. Using Docker

1. **Build the Docker image:**
   ```bash
   docker build -t crud-spring-boot .
   ```

2. **Run the container:**
   ```bash
   docker run -d -p 8081:8080 --name crud-app crud-spring-boot
   ```

3. **Access the application:**
   - Main app: http://localhost:8081/students
   - H2 Console: http://localhost:8081/h2-console

### 4. Using Docker Compose (Production Ready)

1. **Start with PostgreSQL database:**
   ```bash
   docker-compose up -d --build
   ```

2. **Access the application:**
   - Main app: http://localhost:8081/students
   - Database: localhost:5432

## 🚀 Railway Deployment (Recommended)

### Quick Deploy to Railway

1. **Visit Railway**: Go to [railway.app](https://railway.app)
2. **Sign up/Login**: Use your GitHub account
3. **Create New Project**: Click "New Project"
4. **Deploy from GitHub**: Select "Deploy from GitHub repo"
5. **Select Repository**: Choose `Yash1889/crud-spring-boot`
6. **Wait for Deployment**: Railway will automatically:
   - Detect it's a Java project
   - Install Maven and Java 17
   - Build the project
   - Deploy your application
7. **Access Your App**: Railway will provide a public URL (like `https://your-app-name.railway.app`)

### Railway Features
- ✅ **Automatic deployments** from GitHub
- ✅ **Free tier** available
- ✅ **Custom domains** support
- ✅ **Environment variables** for configuration
- ✅ **Built-in monitoring** and logs
- ✅ **SSL/HTTPS** automatically enabled

## Accessing the Application

Once the application is running:

-   **Student CRUD App**: Open your web browser and go to `http://localhost:8080/students`
-   **H2 Database Console**: Go to `http://localhost:8080/h2-console`
    -   JDBC URL: `jdbc:h2:mem:studentdb`
    -   User Name: `sa`
    -   Password: (leave blank)
    -   Click "Connect". You can then inspect the `STUDENTS` table.

## Production Deployment

For production deployment, the application includes:
- Docker configuration for containerization
- Docker Compose setup with PostgreSQL
- Production-ready configuration files
- Railway deployment configuration

The application is ready for deployment to any cloud platform that supports Java applications or Docker containers.
