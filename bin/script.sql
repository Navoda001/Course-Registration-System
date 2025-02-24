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

INSERT INTO courses (courseName, creditHours, department, prerequisites, enrollmentCapacity)
VALUES
('Introduction to Programming', 3, 'Computer Science','None', 100),
('Data Structures', 3, 'Computer Science', 'Should passed Introduction to Programming', 80),
('Database Systems', 3, 'Computer Science', 'Should passed Data Structures', 75),
('Operating Systems', 4, 'Computer Science', 'Should passed Data Structures', 70),
('Calculus I', 4, 'Mathematics', ' None ', 120),
('Physics I', 4, 'Physics','None', 110);

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

INSERT INTO faculties (facultyName, userName, contactInfo, facultyPassword)
VALUES
('IT', 'it', 'it@university.edu', 'b86c23d487d096d98dfb47587032ace3f9a2013eae92e1602711a43ad855cc17'), 
('Engineering', 'engineering', 'engineering@university.edu', '54c305e1a3c4522b44eb062ba1b6135cfb9625573b8b18dab540802fd5c3cb1d'), 
('Architecture', 'architecture', 'architecture@university.edu', '8e61e551e5847c6f61c22230f6fd73f0236d2bf007076d5d2a6f30b1e40da6fd'); 

# UserName = it and password = facultyPass123
# UserName = engineering and password = facultyPass456
# UserName = architecture and password = facultyPass789

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

INSERT INTO admins (adminName, userName, facultyId, department, contact_info, adminPassword)
VALUES
('John Doe', 'johndoe', 1001, 'Computer Science', 'john.doe@example.com', 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f'), 
('Jane Smith', 'janesmith', 1002, 'Mathematics', 'jane.smith@example.com', 'c6ba91b90d922e159893f46c387e5dc1b3dc5c101a5a4522f03b987177a24a91'), 
('Mike Johnson', 'mikejohnson', 1003, 'Physics', 'mike.johnson@example.com', '5efc2b017da4f7736d192a74dde5891369e0685d4d38f2a455b6fcdab282df9c'); 

# UserName = johndoe and password = password123
# UserName = janesmith and password = password456
# UserName = mikejohnson and password = password789
