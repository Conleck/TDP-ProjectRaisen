DROP DATABASE IF EXISTS employees;
CREATE DATABASE IF NOT EXISTS employees;
USE employees;

DROP TABLE IF EXISTS Employee;
DROP TABLE IF EXISTS Department;

CREATE TABLE Employee (
	id int AUTO_INCREMENT PRIMARY KEY,
	department_id int NOT NULL,
	first_name varchar(25) NOT NULL,
	last_name varchar(25) NOT NULL,
	address varchar(100) NOT NULL,
	nin varchar (9) NOT NULL,
	iban varchar (34) NOT NULL,
	starting_salary float (10,2) NOT NULL,
	FOREIGN KEY (department_id) REFERENCES Department(id)
);

CREATE TABLE Department (
	id int AUTO_INCREMENT PRIMARY KEY NOT NULL,
	department_name varchar(30) NOT NULL,
	head_of_department_id int NULL,
	FOREIGN KEY (head_of_department_id) REFERENCES Employee(id)
);
