# Employee Rating System

A simple RESTful Spring Boot application for managing employee details along with their performance scores (ratings).  
It supports full CRUD operations and allows incrementing or decrementing an employee's score.

---

##  Features

| Endpoint | Method | Description |
| :--- | :---: | :--- |
| `/api/employees` | GET | Fetch all employees |
| `/api/employees/{id}` | GET | Fetch an employee by ID |
| `/api/employees` | POST | Create a new employee |
| `/api/employees` | PUT | Update an employee (name, department, or score) using ID as point of truth |
| `/api/employees/{id}` | DELETE | Delete an employee by ID |

---

## Project Structure

com.codewithshabaz.employeeratingsystem
├── controller
│   └── EmployeeController.java
├── model
│   └── Employee.java
├── repository
│   └── EmployeeRepository.java
├── service
│   └── EmployeeService.java
├── EmployeeRatingSystemApplication.java
└── resources
    └── application.properties

---

## Technology Stack

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **MySQL Database**
- **Jackson** (for JSON handling)
- **Swagger** (for API documentation)

---

## Core Logic Explained

### Model (`Employee.java`)
Defines the Employee entity with the following fields:
- `id` (auto-generated)
- `name`
- `department`
- `score` (rating)

---

### Repository (`EmployeeRepository.java`)
- Extends `JpaRepository`.
- Provides built-in database methods like `findAll()`, `save()`, `findById()`, `deleteById()`.

---

### Service (`EmployeeService.java`)

- **Add Employee**:  
  Saves a new employee record into the database.

- **Get Employees**:  
  Retrieves all employee records.

- **Get Employee by ID**:  
  Fetches an employee by their unique ID.

- **Update Employee**:  
  - Searches employee by ID.
  - If the `name` is provided ➔ updates the name.
  - If the `department` is provided ➔ updates the department.
  - If `increment=true` ➔ increases the score by 1.
  - If `decrement=true` ➔ decreases the score by 1.
  - Saves the updated employee back to the database.

- **Delete Employee**:  
  Deletes the employee record based on ID.

---

###  Controller (`EmployeeController.java`)
- Exposes RESTful APIs mapped to the corresponding service methods.
- Handles HTTP request/response transformations.
- Follows standard REST principles.

```bash
mvn spring-boot:run
