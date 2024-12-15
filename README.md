# psip_yulu
Challenge puzzle for Yulu PSIP

Task Management API

Overview:
This project is a simple Task Management API built using Spring Boot. It provides RESTful endpoints to create, retrieve, update, and delete tasks. Tasks have attributes like title, description, due_date, and status.

Features:
- Create a Task: Add a new task with a title, description, due date, and status.
- Retrieve Tasks: Fetch all tasks or filter by status.
- Update a Task: Modify the title or status of a task.
- Delete a Task: Remove a task by its ID.

Setup Instructions:
1. Clone the Repository:
   Use the following commands:
   git clone <repository_url>
   cd <repository_folder>

2. Build the Project:
   Ensure Maven is installed and run the following command:
   mvn clean install

3. Run the Application:
   Run the application using the following command:
   mvn spring-boot:run
   By default, the application will start on http://localhost:8080.

API Endpoints:

Create Task:
- Endpoint: POST /tasks
- Request Parameters:
  - title (String) Required: Title of the task.
  - description (String) Optional: Description of the task.
  - due_date (Date) Required: Due date for the task in the format yyyy-MM-dd.
  - status (String) Optional: Status of the task (Pending, In Progress, Completed).
- Example:
  curl -X POST "http://localhost:8080/tasks" -d "title=New Task&description=Details&due_date=2024-12-31&status=Pending"

Get Tasks:
- Endpoint: GET /tasks
- Optional Query Parameter:
  - status (String): Filter tasks by status (Pending, In Progress, Completed).
- Example:
  curl -X GET "http://localhost:8080/tasks?status=Pending"

Update Task:
- Endpoint: PUT /tasks/{id}
- Request Parameters:
  - title (String) Optional: New title for the task.
  - status (String) Optional: New status of the task (Pending, In Progress, Completed).
- Example:
  curl -X PUT "http://localhost:8080/tasks/1" -d "title=Updated Task&status=Completed"

Delete Task:
- Endpoint: DELETE /tasks/{id}
- Path Parameter:
  - id (Integer) Required: The ID of the task to delete.
- Example:
  curl -X DELETE "http://localhost:8080/tasks/1"

Assumptions:
- Tasks are identified by a unique id (automatically generated).
- Status values must be one of: Pending, In Progress, or Completed.
    - An exception is thrown if this is not the case.

Troubleshooting:
If you encounter issues, ensure the following:
1. Java and Maven are correctly installed.
2. The required dependencies are downloaded (mvn clean install should succeed).
3. The application runs without port conflicts (8080 is available).

The project files can be found under the yulu/yulu/src/main/java/com/psip/yulu path in this GitHub repository.
