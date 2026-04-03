# 🚀 Finance Data Processing & Access Control Backend

---

## 📌 Overview

This project is a backend system for a **finance dashboard application** where users interact with financial records based on their roles.

The system is designed to:

* Manage users and roles
* Handle financial transactions
* Provide dashboard analytics
* Enforce role-based access control

The focus of this project is **clean backend design, proper data handling, and logical access control**, rather than just CRUD operations.

---

## 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Security + JWT
* Spring Data JPA
* MySQL
* Maven

---

## 🧠 System Design

The application follows a layered architecture:

controller → service → repository → database

### 📂 Project Structure

src/main/java/com/assignment/zorvyn

* controller → API endpoints
* service → Business logic
* repository → Database interaction
* entity → Data models
* dto → Response structures
* security → JWT & filters
* config → Security configuration
* exception → Global error handling

---

## 👥 Role-Based Access Control

| Role    | Permissions                |
| ------- | -------------------------- |
| ADMIN   | Full access (CRUD + users) |
| ANALYST | Read records + dashboard   |
| VIEWER  | Read-only access           |

---

## 🔐 Authentication

JWT-based authentication is implemented.

### Login

POST /api/auth/login?email=[admin@test.com](mailto:admin@test.com)&password=1234

Returns a JWT token.

---

## 📡 API Endpoints

---

### 👤 User Management (ADMIN Only)

#### 🔹 Create User

```http
POST /api/users
```

**Description:** Creates a new user with a specific role.

**Sample Body:**

```json
{
  "name": "Test User",
  "email": "test@test.com",
  "password": "1234",
  "role": "VIEWER",
  "active": true
}
```

**Response:**

```json
{
  "id": 4,
  "name": "Test User",
  "role": "VIEWER"
}
```

---

#### 🔹 Get All Users

```http
GET /api/users
```

**Description:** Returns list of all users.

---

#### 🔹 Get User by ID

```http
GET /api/users/{id}
```

**Description:** Fetch a specific user.

---

#### 🔹 Update User

```http
PUT /api/users/{id}
```

**Description:** Updates user details.

---

#### 🔹 Delete User

```http
DELETE /api/users/{id}
```

**Description:** Deletes a user.

---

#### 🔹 Update User Role

```http
PATCH /api/users/{id}/role?role=ADMIN
```

**Description:** Changes role of user.

---

#### 🔹 Activate/Deactivate User

```http
PATCH /api/users/{id}/status?active=false
```

**Description:** Enables or disables user access.

---

### 💰 Financial Records

#### 🔹 Get All Records

```http
GET /api/records
```

**Description:** Fetch all financial records.

---

#### 🔹 Create Record

```http
POST /api/records
```

**Sample Body:**

```json
{
  "amount": 1000,
  "type": "EXPENSE",
  "category": "Food",
  "date": "2026-04-03",
  "description": "Lunch"
}
```

**Response:**

```json
{
  "id": 10,
  "amount": 1000,
  "type": "EXPENSE"
}
```

---

#### 🔹 Update Record

```http
PUT /api/records/{id}
```

**Description:** Updates existing record.

---

#### 🔹 Delete Record

```http
DELETE /api/records/{id}
```

**Description:** Deletes a record.

---

### 🔍 Filtering Records

```http
GET /api/records/filter
```

**Description:** Fetch records based on conditions.

**Examples:**

```http
/api/records/filter?type=EXPENSE
/api/records/filter?category=Food
/api/records/filter?startDate=2026-01-01&endDate=2026-04-01
```

**Response:**

```json
[
  {
    "amount": 2000,
    "category": "Food"
  }
]
```

---

### 📄 Pagination

```http
GET /api/records/paged?page=0&size=5
```

**Description:** Returns records page by page.

**Response:**

```json
{
  "content": [...],
  "totalPages": 3,
  "totalElements": 15
}
```

---

### 📊 Dashboard APIs

---

#### 🔹 Summary

```http
GET /api/dashboard/summary
```

**Description:** Returns overall financial summary.

**Response:**

```json
{
  "totalIncome": 16000,
  "totalExpense": 6500,
  "netBalance": 9500
}
```

---

#### 🔹 Category Summary

```http
GET /api/dashboard/category-summary
```

**Description:** Total spending grouped by category.

**Response:**

```json
[
  {
    "category": "Food",
    "total": 2000
  }
]
```

---

#### 🔹 Recent Activity

```http
GET /api/dashboard/recent
```

**Description:** Returns latest transactions.

---

#### 🔹 Monthly Trends

```http
GET /api/dashboard/monthly-trends
```

**Description:** Shows monthly aggregated data.

**Response:**

```json
[
  {
    "month": 1,
    "total": 5000
  }
]
```

---


---

## 🧪 Validation & Error Handling

The system handles:

* Invalid input
* Missing fields
* Invalid roles
* Resource not found

Example:

```json
{
"amount": "Amount must be positive",
"category": "Category cannot be empty"
}
```

---

## 🗄️ Database Schema

### Users Table

* id
* name
* email
* password
* role
* active

---

### Financial Records Table

* id
* amount
* type
* category
* date
* description
* user_id

---

## ⚙️ Setup Instructions

1. Clone repository
   git clone <your-repo-link>

2. Create database
   CREATE DATABASE finance_db;

3. Configure application.properties

```
spring.datasource.url=jdbc:mysql://localhost:3306/finance_db
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

```

4. Run application
   mvn spring-boot:run

---

## 🧪 Testing Flow

1. Login → get JWT
2. Test ADMIN endpoints
3. Test ANALYST restrictions
4. Test VIEWER restrictions
5. Test dashboard APIs

---

## ⚠️ Assumptions

* Single currency system
* No multi-user sharing
* Password stored as plain text (for simplicity)
* JWT used for authentication

---

## 🚀 Features Implemented

* JWT Authentication
* Role-based access control
* CRUD operations
* Filtering
* Pagination
* Dashboard analytics
* Validation & error handling

---

## 💡 Future Improvements

* Password encryption (BCrypt)
* Swagger documentation
* Unit testing
* Rate limiting
* Soft delete

---

## 🧠 Final Thoughts

This project demonstrates:

* Clean architecture
* Backend design thinking
* Secure access control
* Efficient data handling

The goal was to build a **well-structured backend system**, not just a CRUD application.

---
