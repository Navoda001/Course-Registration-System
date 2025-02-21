DROP DATABASE IF EXISTS course_registration_system;
CREATE DATABASE IF NOT EXISTS course_registration_system;
SHOW DATABASES;
USE course_registration_system;

#====================================================================================================

DROP TABLE IF EXISTS students;
CREATE TABLE students (
    studentId INT AUTO_INCREMENT PRIMARY KEY,
    studentName VARCHAR(100) NOT NULL,
    userName VARCHAR(50) UNIQUE NOT NULL,
    dateOfBirth DATE NOT NULL,
    contactInfo VARCHAR(50) NOT NULL,
    studentPassword VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 1000;

SHOW TABLES ;
DESCRIBE students;

#====================================================================================================
DROP TABLE IF EXISTS courses;
CREATE TABLE courses (
    courseId INT AUTO_INCREMENT PRIMARY KEY,
    courseName VARCHAR(50) NOT NULL,
    creditHours INT NOT NULL,
    department VARCHAR(50) NOT NULL,
    prerequisites VARCHAR(200),
    enrollmentCapacity INT NOT NULL
) AUTO_INCREMENT = 1000;

SHOW TABLES ;
DESCRIBE courses;

#====================================================================================================

DROP TABLE IF EXISTS academic_records;
CREATE TABLE academic_records (
    studentId INT NOT NULL,
    courseId INT NOT NULL,
    semester VARCHAR(20) NOT NULL,
    grade CHAR(2) NOT NULL,
    PRIMARY KEY (studentId, courseId, semester), 
    FOREIGN KEY (studentId) REFERENCES students(studentId) ON DELETE CASCADE,
    FOREIGN KEY (courseId) REFERENCES courses(courseId) ON DELETE CASCADE
);

SHOW TABLES ;
DESCRIBE academic_records;

#====================================================================================================

DROP TABLE IF EXISTS enrollments;
CREATE TABLE enrollments (
    studentId INT NOT NULL,
    courseId INT NOT NULL,
    semester VARCHAR(20) NOT NULL,
    academicYear INT Not NULL,
    enrollmentDate DATE NOT NULL,
    PRIMARY KEY (studentId, courseId),
    FOREIGN KEY (studentId) REFERENCES students(studentId) ON DELETE CASCADE,
    FOREIGN KEY (courseId) REFERENCES courses(courseId) ON DELETE CASCADE
);

SHOW TABLES ;
DESCRIBE enrollments;

#====================================================================================================
DROP TABLE IF EXISTS faculties;
CREATE TABLE faculties (
    facultyId INT PRIMARY KEY AUTO_INCREMENT,
    facultyName VARCHAR(100) NOT NULL,
    userName VARCHAR(50) UNIQUE NOT NULL, 
    contactInfo VARCHAR(255),
    facultyPassword VARCHAR(255) NOT NULL
) AUTO_INCREMENT = 1000;

SHOW TABLES ;
DESCRIBE faculties;

#====================================================================================================
DROP TABLE IF EXISTS admins;
CREATE TABLE admins (
    adminId INT PRIMARY KEY AUTO_INCREMENT,
    adminName VARCHAR(100) NOT NULL,
    userName VARCHAR(50) UNIQUE NOT NULL,
    facultyId INT,
    department VARCHAR(100) ,
    contact_info VARCHAR(255),
    adminPassword VARCHAR(255) NOT NULL, 
    FOREIGN KEY (facultyId) REFERENCES faculties(facultyId) ON DELETE SET NULL
)AUTO_INCREMENT = 1000;

SHOW TABLES ;
DESCRIBE admins;

