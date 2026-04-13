# 🚀 Service Finder API

A Spring Boot REST API to manage and search local service providers like plumbers, electricians, etc.

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven
* Swagger UI

---

## ✨ Features

* ✅ Add, update, delete service providers
* ✅ Search by service and city
* ✅ Pagination support
* ✅ DTO pattern (Request & Response separation)
* ✅ Input validation
* ✅ Global exception handling
* ✅ Logging using SLF4J
* ✅ Swagger UI for API documentation

---

## 📂 API Endpoints

### ➤ Add Service Provider

POST `/add`

### ➤ Get All (with pagination)

GET `/all?page=0&size=5`

### ➤ Search by Service

GET `/search/service?serviceName=plumber`

### ➤ Search by City

GET `/search/city?city=nashik`

### ➤ Update Service Provider

PUT `/update/{id}`

### ➤ Delete Service Provider

DELETE `/delete/{id}`

---

## 📘 Swagger UI

Access API documentation:

http://localhost:8080/swagger-ui/index.html

---

## ⚙️ How to Run

1. Clone the repository

```
git clone https://github.com/amisha-15/service-finder-API.git
```

2. Open in IntelliJ / Eclipse

3. Configure MySQL in `application.properties`

4. Run the application

5. Open Swagger UI

---

## 🧠 Concepts Used

* REST API design
* Dependency Injection
* DTO Pattern
* Pagination & Sorting
* Exception Handling
* Logging
* JPA & Hibernate

---

## 👩‍💻 Author

Amisha Pawar

---

## ⭐ Future Improvements

* Add authentication (Spring Security + JWT)
* Add file upload
* Improve API design (/providers endpoints)
* Add frontend (optional)

---

