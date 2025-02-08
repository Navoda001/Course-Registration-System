DROP DATABASE IF EXISTS course_registration_system;
CREATE DATABASE IF NOT EXISTS course_registration_system;
SHOW DATABASES;
USE course_registration_system;

#====================================================================================================

DROP TABLE IF EXISTS Student;
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    studentId VARCHAR(20) GENERATED ALWAYS AS (CONCAT('S-', LPAD(Id, 3, '0'))) STORED,
    studentName VARCHAR(100) NOT NULL,
    dateOfBirth DATE NOT NULL,
    programOfStudy VARCHAR(100) ,
    year INT CHECK (year BETWEEN 1 AND 8) NOT NULL,
    contactInfo VARCHAR(50) NOT NULL
);
SHOW TABLES ;
DESCRIBE Student;

#====================================================================================================
DROP TABLE IF EXISTS Course;
CREATE TABLE Course (
    id INT PRIMARY KEY AUTO_INCREMENT,
    courseId VARCHAR(20) GENERATED ALWAYS AS (CONCAT('C-', LPAD(id, 3, '0'))) STORED,
    courseTitle VARCHAR(50) NOT NULL,
    creditHours INT NOT NULL,
    department VARCHAR(50) NOT NULL,
    prerequisites VARCHAR(50) NOT NULL,
    enrollmentCapacity INT NOT NULL
);

SHOW TABLES ;
DESCRIBE Course;

#====================================================================================================

DROP TABLE IF EXISTS AcademicRecord;
CREATE TABLE academicRecord (
    studentId INT NOT NULL,
    courseId INT NOT NULL,
    semester VARCHAR(20) NOT NULL,
    grade CHAR(2) NOT NULL,
    PRIMARY KEY (student_id, course_id,semester), 
    FOREIGN KEY (studentId) REFERENCES Student(studentId) ON DELETE CASCADE,
    FOREIGN KEY (courseId) REFERENCES Course(courseId) ON DELETE CASCADE 
);

SHOW TABLES ;
DESCRIBE AcademicRecord;

#====================================================================================================

CREATE TABLE Enrollments (
    studentId INT,
    courseId INT,
    semester VARCHAR(20) NOT NULL,
    enrollmentDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (studentId, courseId, semester),
    FOREIGN KEY (studentId) REFERENCES Students(studentId) ON DELETE CASCADE,
    FOREIGN KEY (courseId) REFERENCES Courses(courseId) ON DELETE CASCADE
);

SHOW TABLES ;
DESCRIBE Enrollments;

#====================================================================================================

CREATE TABLE Users (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL, -- Store hashed passwords
    role ENUM('student', 'faculty', 'admin') NOT NULL,
    studentId INT UNIQUE, -- Null for non-students
    facultyId INT UNIQUE, -- Null for non-faculty
    adminId INT UNIQUE, -- Null for non-admins
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (studentId) REFERENCES Students(studentId) ON DELETE SET NULL,
    FOREIGN KEY (facultyId) REFERENCES Faculty(facultyId) ON DELETE SET NULL,
    FOREIGN KEY (adminId) REFERENCES Admin(adminId) ON DELETE SET NULL
);

SHOW TABLES ;
DESCRIBE Users;

#====================================================================================================

CREATE TABLE Faculty (
    facultyId INT PRIMARY KEY AUTO_INCREMENT,
    facultyName VARCHAR(100) NOT NULL,
    contactInfo VARCHAR(255)
);

SHOW TABLES ;
DESCRIBE Faculty;

#====================================================================================================

CREATE TABLE Admin (
    adminId INT PRIMARY KEY AUTO_INCREMENT,
    Adminame VARCHAR(100) NOT NULL,
    facultyId VARCHAR(100) ,
    department VARCHAR(100) ,
    contact_info VARCHAR(255)
);

SHOW TABLES ;
DESCRIBE Admin;