-- Creating Student model and operating it
-- Some rule lines
-- Database, table, and field names shall be
-- either lower case or uppercase for avoiding conflicts
-- Create Database
create database ngp; -- one time

use ngp; -- whenever you start database

-- Create a application user
CREATE USER 'ngp-user'@'localhost' IDENTIFIED BY 'ngp-pass';

-- Assiging previllages
GRANT ALL ON ngp.* TO 'ngp-user'@'localhost';

-- Create Table -- One time
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(10),
    father_name VARCHAR(10),
    age INT,
    class VARCHAR(10),
    gpa DECIMAL(3, 2)
);
-- Alter Table

describe students; -- to view a database

ALTER TABLE students
MODIFY COLUMN id INT AUTO_INCREMENT,
MODIFY COLUMN name VARCHAR(30),
MODIFY COLUMN father_name VARCHAR(30);

ALTER TABLE students
MODIFY COLUMN name VARCHAR(30),
MODIFY COLUMN father_name VARCHAR(30);
-- Operations on the database CRUD
-- Insert/Create record (C)
-- Select/Read record (R)
-- Update/Change record (U)
-- Delete/Remove record (D)

-- Inserting single record in a table
INSERT INTO students (name, father_name, age, class, gpa)
VALUES ('Kumar', 'Mailsamy', 20, 'BSc IT', 3.5);

-- Inserting multiple records in a table

INSERT INTO students (name, father_name, age)
VALUES ('Sona', 'Muthuvel', 20),
('Suriya', 'Prasath', 21),
('Priya', 'Thangadurai', 19),
('John', 'Prakash', 19),
('Rameela', 'Ismayil', 21);

-- Selecting all records
SELECT * FROM students;

-- Selecting specific record

SELECT * FROM students WHERE name = 'Kumar';

-- Deleting a specific record

DELETE FROM students WHERE name = 'Kumar';

-- Select
UPDATE students SET gpa=9.3 WHERE id=8;

drop table students; -- Delete table if necessary

commit;