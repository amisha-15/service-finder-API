# 🚀 Local Service Finder API

A Spring Boot REST API to manage and search local service providers like plumbers, electricians, carpenters, etc.

---

## 📌 Features

* Add new service providers
* View all providers
* Search by service type (Plumber, Electrician, etc.)
* Search by city
* Update provider details
* Delete provider
* Input validation (name, contact, etc.)
* Global exception handling
* Case-insensitive search

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Maven

---

## 📂 Project Structure

```
controller
service
repository
model
exception
```

---

## 🔗 API Endpoints

| Method | Endpoint                            | Description       |
| ------ | ----------------------------------- | ----------------- |
| POST   | /add                                | Add new provider  |
| GET    | /all                                | Get all providers |
| GET    | /search/service?serviceName=Plumber | Search by service |
| GET    | /search/city?city=Nashik            | Search by city    |
| PUT    | /update/{id}                        | Update provider   |
| DELETE | /delete/{id}                        | Delete provider   |

---

## 🧪 Sample Request (POST)

```json
{
  "name": "Ravi",
  "service": "Plumber",
  "city": "Nashik",
  "contact": "9876543210"
}
```

---

## ⚙️ How to Run

1. Clone the repository
2. Open in IntelliJ IDEA
3. Configure MySQL in `application.properties`
4. Run the application
5. Test APIs using Postman

---

## 💡 Future Improvements

* Add authentication (Spring Security)
* Add rating & reviews
* Add image upload
* Build frontend (React)

---

## 👩‍💻 Author

* Amisha Pawar
