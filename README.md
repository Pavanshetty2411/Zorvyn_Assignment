# 🚀 Finance Data Processing & Access Control Backend

---

## 📌 Overview

This project is a backend system for a **finance dashboard application** where users interact with financial records based on their roles.

The system is designed to:

* Manage users and roles
* Handle financial transactions
* Provide dashboard analytics
* Enforce role-based access control

This is not just CRUD — it demonstrates **real backend architecture, security, and data handling**.

---

## 🌐 Live API

```text
https://pavanshetty-zorvyn-assignment.up.railway.app
```

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Security + JWT
* Spring Data JPA
* MySQL (Railway)
* Maven

---

## 🧠 System Design

```
controller → service → repository → database
```

### 📂 Project Structure

```
controller → API endpoints  
service → Business logic  
repository → DB interaction  
entity → Models  
dto → Data transfer  
security → JWT + filters  
config → Security config  
exception → Error handling  
```

---

## 👥 Role-Based Access Control

| Role    | Permissions      |
| ------- | ---------------- |
| ADMIN   | Full access      |
| ANALYST | Read + dashboard |
| VIEWER  | Read-only        |

---

# 🔐 Authentication

JWT-based authentication is implemented.

---

## 🔹 Login

POST
`/api/auth/login`

---

## 🧪 How to Execute Login

1. Open Postman
2. Select **POST method**
3. Enter:

```
https://pavanshetty-zorvyn-assignment.up.railway.app/api/auth/login?email=admin@test.com&password=1234
```

4. Click **Send**

---

## ✅ Response

You will get a JWT token:

```
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

## 🔑 How to Use the Token

All APIs (except login) require this token.

---

### 🔹 Steps

1. Copy the token
2. Open any request in Postman
3. Go to **Headers**
4. Add:

```
Key: Authorization
Value: Bearer <TOKEN>
```

---

### ✅ Example

```
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

### ⚠️ Important

* Always include `Bearer`
* Add space after `Bearer`
* Without token → 403 error (expected)

---

# 📡 API Endpoints

---

# 👤 User Management (ADMIN Only)

---

### 🔹 Create User

POST
`/api/users`

**How to Execute:**

* URL:

```
https://pavanshetty-zorvyn-assignment.up.railway.app/api/users
```

* Headers:

```
Authorization: Bearer <TOKEN>
```

* Body:

```json
{
  "name": "Test User",
  "email": "test@test.com",
  "password": "1234",
  "role": "VIEWER",
  "active": true
}
```

---

### 🔹 Get All Users

GET
`/api/users`

---

### 🔹 Get User by ID

GET
`/api/users/{id}`

---

### 🔹 Update User

PUT
`/api/users/{id}`

---

### 🔹 Delete User

DELETE
`/api/users/{id}`

---

### 🔹 Update Role

PATCH
`/api/users/{id}/role?role=ADMIN`

---

### 🔹 Activate/Deactivate

PATCH
`/api/users/{id}/status?active=false`

---

# 💰 Financial Records

---

### 🔹 Create Record

POST
`/api/records`

```json
{
  "amount": 1000,
  "type": "EXPENSE",
  "category": "Food",
  "date": "2026-04-03",
  "description": "Lunch"
}
```

---

### 🔹 Get All Records

GET
`/api/records`

---

### 🔹 Update Record

PUT
`/api/records/{id}`

---

### 🔹 Delete Record

DELETE
`/api/records/{id}`

---

# 🔍 Filtering

GET
`/api/records/filter`

Examples:

```
/api/records/filter?type=EXPENSE
/api/records/filter?category=Food
/api/records/filter?startDate=2026-01-01&endDate=2026-04-01
```

---

# 📄 Pagination

GET
`/api/records/paged?page=0&size=5`

---

# 📊 Dashboard APIs

---

### 🔹 Summary

GET
`/api/dashboard/summary`

---

### 🔹 Category Summary

GET
`/api/dashboard/category-summary`

---

### 🔹 Recent Activity

GET
`/api/dashboard/recent`

---

### 🔹 Monthly Trends

GET
`/api/dashboard/monthly-trends`

---

# 🧪 Testing Flow

Follow this EXACT order:

1. Login → get token
2. Add token in headers
3. Test APIs
4. Verify role-based access

---

# ⚠️ Important Notes

* Browser access → 403 (expected)
* Always use Postman
* JWT is mandatory

---

# 🗄️ Database

Hosted on Railway MySQL

Tables:

* users
* financial_record

---

# 🧪 Validation & Error Handling

Handles:

* Invalid input
* Missing fields
* Unauthorized access
* Resource not found

---

# 🚀 Features

* JWT Authentication
* Role-based access control
* CRUD operations
* Filtering
* Pagination
* Dashboard analytics

---

# 💡 Future Improvements

* Password encryption (BCrypt)
* Swagger documentation
* Unit testing
* Rate limiting

---

# 🧠 Final Thoughts

This project demonstrates:

* Clean backend architecture
* Secure API design
* Role-based logic
* Scalable data handling

The goal was to build a **production-like backend**, not just a basic CRUD system.

---
