# 🚕 Jride - Mini Ride Booking System

Jride is a lightweight ride booking system built using Java and Spring Boot. It allows passengers to request rides and drivers to accept them. The app supports ride status updates and maintains history for both passengers and drivers.

---

## 🔧 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **H2 In-Memory Database**
- **Maven**
- **Postman** (for API Testing)

---

## ✅ Core Features

- 👤 Register Passenger
- 👨‍✈️ Register Driver
- 📍 Request a Ride (pickup → drop)
- ✅ Accept / ❌ Reject Ride
- 🚦 Update Ride Status (`Requested → Accepted → In Progress → Completed`)
- 📜 View Ride History (for both Driver & Passenger)

---
## 🧪 How to Test

Use [Postman](https://www.postman.com/) to test the following endpoints:
- `POST /api/register/passenger`
- `POST /api/register/driver`
- `POST /api/ride/request`
- `PUT /api/ride/accept`
- `PUT /api/ride/status`
- `GET /api/ride/history/passenger`
- `GET /api/ride/history/driver`

---

## 👩‍💻 Developed By

- Fatima Mustafa
