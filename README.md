# 🎓 User Management System (Java + JDBC + MySQL + Servlets + JPA)

A console-based CRUD application to manage user records.

## 🛠️ Technologies Used
- Java (JDK 22)
- JDBC
- MySQL
- Servlets
- JPA
- MVC Design Pattern

## ✨ Features
- Add new user
- View all users records in homepage
- Update user records
- Delete user records

## 📦 How to Run
1. Create MySQL database:
   ```sql
   CREATE DATABASE users_db;
   USE users_db;
   CREATE TABLE users (
       ID INT PRIMARY KEY,
       name VARCHAR(50),
       email VARCHAR(50),
       country VARCHAR(30),
   );
   
2. Update DB credentials in DBConnection.java

3. Add MySQL Connector JAR in your project’s classpath

4. Run Main.java
