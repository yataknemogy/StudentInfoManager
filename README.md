# Student Information Management

This application is designed for managing student information using a MySQL database.

## MySQL Database Structure

The database contains the following fields for each student:
- ID (student identifier, auto-incrementing)
- First Name
- Last Name
- Age
- Average Score

## Functionality in Students.java

- Add a new student to the database
- Update student information by their ID
- Search for a student by their ID and display their information
- Display a list of all students in the database
- Display a list of all students sorted by average score (from lowest to highest)
- Display a list of all students sorted by first name (alphabetically)
- Use JDBC (Java Database Connectivity) to connect to the database, execute SQL queries, and handle results.

## Using MySQL Database

To use this application, you need to install and configure the MySQL database on your computer or server.

### Installing and Configuring MySQL

1. Install MySQL on your computer by following the instructions on the [official MySQL website](https://dev.mysql.com/downloads/).

2. Create a database named `students_db` and a table named `students` using the following SQL script:

   ```sql
   CREATE DATABASE students_db;
   USE students_db;

   CREATE TABLE students (
       ID INT AUTO_INCREMENT PRIMARY KEY,
       FirstName VARCHAR(255),
       LastName VARCHAR(255),
       Age INT,
       AverageScore FLOAT
   );

## License

This project is licensed under the MIT License.
