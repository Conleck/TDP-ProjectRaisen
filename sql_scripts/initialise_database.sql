DROP TABLE Employee;
DROP TABLE Department;

CREATE TABLE Employee (
	id int AUTO_INCREMENT PRIMARY KEY,
    department_id int,
	first_name varchar(25),
	last_name varchar(25),
	address varchar(100),
	nin varchar (9),
	iban varchar (34),
	starting_salary float (10,2),
    FOREIGN KEY (department_id) REFERENCES Department(id)
);

CREATE TABLE Department (
	id int AUTO_INCREMENT PRIMARY KEY,
	department_name varchar(30),
    head_of_department_id int,
    FOREIGN KEY (head_of_department_id) REFERENCES Employee(id)
);
