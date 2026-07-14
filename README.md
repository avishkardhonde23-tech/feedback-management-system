# 📝 Role-Based Feedback Management System

<p align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.x-6DB33F?style=for-the-badge&logo=springboot)
![Spring Security](https://img.shields.io/badge/SpringSecurity-6-6DB33F?style=for-the-badge&logo=springsecurity)
![MySQL](https://img.shields.io/badge/MySQL-8-blue?style=for-the-badge&logo=mysql)
![Hibernate](https://img.shields.io/badge/Hibernate-JPA-brown?style=for-the-badge&logo=hibernate)
![Maven](https://img.shields.io/badge/Maven-Build-red?style=for-the-badge&logo=apachemaven)

</p>

---

## 📖 Overview

A secure role-based Feedback Management System developed using Java, Spring Boot, Spring Security, Hibernate/JPA, Thymeleaf, and MySQL.

The application enables users to register, log in securely, submit feedback, and allows administrators to approve, reject, or delete submitted feedback.

---

# 🚀 Features

- User Registration
- Secure Login
- Spring Security Authentication
- Role-Based Authorization
- Submit Feedback
- View Personal Feedback
- Admin Dashboard
- Approve Feedback
- Reject Feedback
- Delete Feedback
- CRUD Operations
- MySQL Database Integration
- Form Validation

---

# 🛠 Tech Stack

- Java 21
- Spring Boot
- Spring Security
- Spring MVC
- Hibernate / JPA
- MySQL
- Thymeleaf
- Bootstrap
- Maven

---

# 📂 Project Structure

```
src
 ├── controller
 ├── service
 ├── repository
 ├── entity
 ├── dto
 ├── security
 ├── config
 └── resources
```

---

# 🔐 User Roles

## User

- Register
- Login
- Submit Feedback
- View Feedback

## Admin

- Login
- View All Feedback
- Approve Feedback
- Reject Feedback
- Delete Feedback

---

# 📸 Screenshots

## Login Page

*(Add login.png here)*

---

## Registration Page

*(Add register.png here)*

---

## User Dashboard

*(Add user-dashboard.png here)*

---

## Admin Dashboard

*(Add admin-dashboard.png here)*

---

# 🏗 Architecture

```
Browser
    │
    ▼
Spring Boot Controller
    │
    ▼
Service Layer
    │
    ▼
Repository (JPA)
    │
    ▼
MySQL Database
```

---

# ⚙ Installation

```bash
git clone https://github.com/avishkardhonde23-tech/feedback-management-system.git

cd feedback-management-system

mvn clean install

mvn spring-boot:run
```

---

# 📬 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | /register | Register User |
| POST | /login | Login User |
| GET | /feedbacks | User Dashboard |
| POST | /feedback | Submit Feedback |
| GET | /admin | Admin Dashboard |

---

# 🎯 Future Improvements

- JWT Authentication
- Swagger Documentation
- Docker Support
- Email Notifications
- Unit Testing
- REST API Versioning

---

# 👨‍💻 Author

**Avishkar Dhonde**

LinkedIn:
https://www.linkedin.com/in/avishkardhonde23

GitHub:
https://github.com/avishkardhonde23-tech
