CREATE DATABASE IF NOT EXISTS hostpital_lecture12
CHARACTER SET utf8mb4;

USE hostpital_lecture12;
SELECT DATABASE();

CREATE TABLE IF NOT EXISTS doctors(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS patients(
    id BIGINT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    doctor_id BIGINT NULL,
    CONSTRAINT fk_patients_doctor 
    FOREIGN KEY (doctor_id) REFERENCES doctors(id)
);

SHOW TABLES;

INSERT INTO DOCTORS(id,name)
VALUES (1, 'Dr Watson'), (2, 'Dr Banner'), (3, 'Dr Strange');

INSERT INTO PATIENTS(id,name,age, doctor_id)
VALUES
(1, 'James', 20, 1),
(2, 'Jean', 30, 1),
(3, 'Jean', 40, 2),
(4, 'Ron', 17, NULL),
(5, 'Luna', 30, 2),
(6, 'JOhn', 60, NULL);



SELECT id, name FROM patients WHERE doctor_id = 1;
SELECT id, name FROM patients WHERE doctor_id IS NULL;


SELECT d.id AS doctor_id, d.name AS doctor,
       p.id AS patient_id, p.name AS patient
FROM doctors d
RIGHT JOIN patients p ON p.doctor_id = d.id
ORDER BY d.id, p.id;

SELECT d.name AS doctor,
       p.name AS patient
FROM doctors d
LEFT JOIN patients p ON p.doctor_id = d.id
WHERE p.id IS NOT NULL
ORDER BY d.id, p.id;

-- SHOW ALL DOCTORS AND THEIR PATIENTS WHO ARE OLDER THAN 30
SELECT d.name AS doctor,
       p.name AS patient, p.id AS patient_id
FROM doctors d
LEFT JOIN patients p ON p.doctor_id = d.id AND p.age>=30
ORDER BY d.id, p.id;

SELECT d.name AS doctor,
       p.name AS patient, p.id AS patient_id
FROM doctors d
LEFT JOIN patients p ON p.doctor_id = d.id
WHERE p.age>=30
ORDER BY d.id, p.id;

SELECT * FROM DOCTORS;
SELECT * FROM PATIENTS;




CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR (255) NOT NULL,
    manager_id INT NULL
);

INSERT INTO employees (id, name, manager_id)
VALUES (1, 'Hermoine', NULL),
(2, 'Ron', 1),
(3, 'Harry', 1),
(4, 'Nash', 2);

SELECT * FROM EMPLOYEES;


SELECT e.name AS Emp, m.name AS Man
FROM employees e
LEFT JOIN employees m ON e.manager_id = m.id
ORDER by e.id;

DROP TABLE employees;



-- Aggregate functions
-- min
-- max
-- avg
-- count(*) --> counts all rows
-- sum

SELECT COUNT(*) AS total_patients,
COUNT(doctor_id) AS assigned_patients,
AVG(age) AS average_age,
MIN(age) AS mini_age,
MAX(age) AS max_age
FROM Patients;

SELECT * FROM patients;
SELECT * FROM doctors;

SELECT doctor_id, COUNT(*) 
FROM patients
GROUP BY doctor_id;


SELECT d.name AS docName, p1.doctor_id AS docID,
p1.id AS p1Id, p1.name as p1Name,
p2.id AS p2Id, p2.name as p2Name
FROM patients p1
INNER JOIN patients p2 
ON p1.doctor_id = p2.doctor_id AND p1.id < p2.id
INNER JOIN doctors d
ON p1.doctor_id = d.id;

-- WRITE A QUERY TO RETURN ALTERNATE DOCTORS FOR PATIENT
SELECT
p.name AS patient,
p.id AS pId,
d.name AS doctor,
d.id AS dId
FROM patients p
INNER JOIN doctors d
ON p.doctor_id <> d.id OR p.doctor_id IS NULL
ORDER BY p.id, d.id;


SELECT d.id, d.name, COUNT(p.id) AS patient_count
FROM doctors d
LEFT JOIN patients p 
ON p.doctor_id = d.id
GROUP BY d.id
HAVING COUNT(p.id)>0;


-- Write a query to get patient second eldest patient
SELECT MAX(age) AS second_highest
FROM patients
WHERE age < (SELECT MAX(age) FROM patients);





