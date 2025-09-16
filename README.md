TODO API
========
Java 21 + Spring Boot REST API for managing tasks.

Features:
---------
- Create, Read, Update, Delete tasks
- Task categories
- Task status: TODO, IN_PROGRESS, DONE
- Filter tasks by category or status
- H2 in-memory database with console

Quick Start:
------------
1. Clone the repo:
   git clone <YOUR_REPO_URL>
   cd todoapi

2. Run the API:
   - Linux / macOS: ./mvnw spring-boot:run
   - Windows: mvnw.cmd spring-boot:run

3. API Endpoints:
   - GET / → API status
   - GET /tasks → List tasks
   - POST /tasks → Create task
   - PUT /tasks/{id} → Update task
   - DELETE /tasks/{id} → Delete task
