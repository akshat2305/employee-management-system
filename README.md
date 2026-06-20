# Employee Management System

A RESTful Employee Management System built using **Spring Boot**, **Spring Data JPA**, and **PostgreSQL**. This project demonstrates layered architecture, database integration, validation, and global exception handling.

---

## 🚀 Features

* Create Employee
* Get All Employees
* Get Employee by ID
* Update Employee
* Delete Employee
* PostgreSQL database integration
* Spring Data JPA repository layer
* Custom exception handling
* Global exception handling using `@RestControllerAdvice`
* Request validation using `@Valid`
* Custom validation error responses

---

## 🛠 Tech Stack

* Java 24
* Spring Boot
* Spring Web
* Spring Data JPA
* PostgreSQL
* Maven
* Lombok
* Jakarta Validation
* Postman

---

## 📂 Project Structure

```text
src/main/java/com/akshat/employee_management_system
│
├── controller
├── service
├── repository
├── entity
├── exception
└── EmployeeManagementSystemApplication
```

---

## 🏗 Architecture

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
PostgreSQL Database
```

---

## API Endpoints

### Get all employees

```http
GET /api/employees
```

### Get employee by ID

```http
GET /api/employees/{id}
```

### Create employee

```http
POST /api/employees
```

Sample Request:

```json
{
  "name": "Akshat",
  "email": "akshat@gmail.com",
  "department": "Engineering"
}
```

### Update employee

```http
PUT /api/employees/{id}
```

### Delete employee

```http
DELETE /api/employees/{id}
```

---

## Validation

The application validates:

* Name cannot be blank
* Email cannot be blank
* Department cannot be blank

Example validation response:

```json
{
  "name": "Name cannot be blank",
  "email": "Email cannot be blank",
  "department": "Department cannot be blank"
}
```

---

## Exception Handling

### Employee Not Found

Response:

```text
404 NOT FOUND
Employee not found
```

---

## Future Improvements

* DTO Layer
* ResponseEntity
* Pagination and Sorting
* Swagger/OpenAPI Documentation
* Unit Testing using JUnit and Mockito
* Docker Support
* Deployment

---

## Author

**Akshat Khanna**

Backend Developer | Java | Spring Boot | PostgreSQL
