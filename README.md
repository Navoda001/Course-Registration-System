# Course Management System

## Table of Contents
- [Project Overview](#project-overview)
- [System Functionalities](#system-functionalities)
- [System Architecture](#system-architecture)
- [System Requirements](#system-requirements)
- [Installation & Setup](#installation--setup)
- [Usage Guide](#usage-guide)
- [Contributors](#contributors)

## Project Overview
The **Course Management System** is a comprehensive application designed to facilitate course enrollment, student management, and reporting functionalities for educational institutions. It provides a secure and efficient way for students, faculty, and administrators to manage courses and registrations.

## System Functionalities
1. **User Login and Security**
   - Role-based access control (RBAC) for students, faculty, and administrative staff.
   - Secure authentication system to protect sensitive data.

2. **Manage Courses (CRUD)**
   - Create, read, update, and delete course information.
   - Faculty or admins can input and modify course details.

3. **Manage Students (CRUD)**
   - Add, update, and delete student profiles.

4. **Registration Interface**
   - Students can search, view, and register for courses.
   - Real-time updates on course availability.

5. **Modification of Enrollment**
   - Add or drop courses .
   - Automatic updates for student and course records.

6. **Reporting Tools**
   - Generate reports for administrators, including enrollment statistics.

## System Architecture
The project follows a **Layered Architecture**, which enhances maintainability, scalability, and separation of concerns:

1. **Presentation Layer (UI Layer)**
   - Developed using JavaFX for a user-friendly graphical interface.

2. **Controller Layer**
   - Manages communication between the UI and business logic.
   - Processes user actions and forwards them to the appropriate service methods.
   
3. **Business Logic Layer (Service Layer)**
   - Contains core functionalities and logic for handling course enrollment, course records, and  student records.
   
4. **Data Access Layer (DAO Layer)**
   - Manages interactions with the database using JDBC.
   - Implements CRUD operations for courses, students, and enrollments.

5. **Database Layer**
   - Uses MySQL for storing student, course, and enrollment data.

## System Requirements
- **Operating System**: Windows, macOS, or Linux
- **Programming Language**: Java (JavaFX for UI)
- **Database**: MySQL
- **IDE**: IntelliJ IDEA / VisualCode / NetBeans
- **Dependencies**:
  - JavaFX
  - JDBC Driver for Database Connectivity

## Installation & Setup
### 1. Clone the Repository
```sh
git clone https://github.com/Navoda001/Course-Registration-System.git
cd Course-Registration-System
```
### 2. Set Up Database
- Import the provided SQL script into your database.
- Configure database credentials in the `script` file.

### 3. Build and Run the Application
- Open the project in your preferred IDE.
- Ensure JavaFX and JDBC dependencies are installed.
- Run the main application file.

## Usage Guide
1. **Login**: Enter your credentials to access the system.
2. **Course Management**: Admins and faculty can add, update, and delete courses.
3. **Enrollment**: Students can enroll in courses, provided prerequisites are met.
4. **Reports**: Generate administrative reports for statistics.

## Contributors
- **Navoda Chathurya** - Project Lead & Developer

