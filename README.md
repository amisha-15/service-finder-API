# 🚀 Service Finder API

A RESTful backend application built using Spring Boot that allows users to manage and search local service providers like plumbers, electricians, etc.

---

## 📌 Features

* Add new service provider
* View all providers (with pagination)
* Search providers by service
* Search providers by city
* Update provider details
* Delete provider
* Input validation
* Global exception handling
* Clean API responses using DTO
* Proper HTTP status codes using ResponseEntity

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Postman

---

## 🏗️ Project Structure

```
com.example.servicefinder
│── controller       → API endpoints
│── service          → Business logic
│── repository       → Database operations
│── model            → Entity (DB table)
│── dto              → Request & Response DTOs
│── exception        → Global exception handling
```

---

## 📂 API Endpoints

### ➕ Add Service Provider

POST /add

**Request Body:**

```
{
  "name": "Ravi",
  "service": "Plumber",
  "city": "Nashik",
  "contact": "9876543210"
}
```

---

### 📄 Get All Providers (Pagination)

GET /all?page=0&size=2

---

### 🔍 Search by Service

GET /search/service?serviceName=Plumber

---

### 🔍 Search by City

GET /search/city?city=Nashik

---

### ✏️ Update Provider

PUT /update/{id}

---

### ❌ Delete Provider

DELETE /delete/{id}

---

## ✅ Validation

* Name cannot be empty
* Service cannot be empty
* City cannot be empty
* Contact must be 10 digits

---

## 🔐 Key Concepts Used

* DTO Pattern (Request & Response separation)
* Pagination (Pageable)
* ResponseEntity for HTTP responses
* Exception Handling using @RestControllerAdvice
* JPA & Hibernate for ORM

---

## 🚀 How to Run

1. Clone the repository
2. Open in IntelliJ
3. Configure MySQL in `application.properties`
4. Run the application
5. Test APIs using Postman

---

## 💡 Future Improvements

* Add authentication (Spring Security)
* Add ratings & reviews
* Build frontend (React)

---

## Author

Amisha Pawar

---
