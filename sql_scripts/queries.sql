DELIMITER $$
CREATE PROCEDURE newEmployee (IN new_f_name varchar(25), 
							  IN new_l_name varchar(25),
                              IN new_address varchar(100),
                              IN new_nin varchar(9),
                              IN new_iban varchar(34),
                              IN new_starting_salary float(10,2)
                              )
BEGIN 

	INSERT INTO Employee 
		(
		first_name, 
		last_name, 
		adress, 
		nin, 
		iban, 
		starting_salary
		) 
    values 
		(
		new_f_name, 
		new_l_name, 
		new_address, 
		new_nin, 
		new_iban, 
		new_starting_salary
		) ;
END $$
DELIMITER ;


DELIMITER ^^
CREATE PROCEDURE generateReport (department)
BEGIN 
	IF department IN (SELECT name from Department) THEN
	SELECT id, first_name, last_name FROM Employee where department = department;
    END IF;

END ^^
DELIMITER ;



