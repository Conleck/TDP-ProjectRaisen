package employee_stuff;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("\n\nWelcome to the Raisen Employee Database!"
				+ "\n\nHere you can store your employee's information :)"
				+ "\n\n\nPlease enter the employee's first name: ");		
		
		String fName = scan.nextLine();	
		
		System.out.print("\nPlease enter the employee's last name: ");
		String lName = scan.nextLine();
		
		System.out.print("\nPlease enter the employee's address: ");
		String address = scan.nextLine();
		
		System.out.print("\nPlease enter the employee's National Insurance No.: ");
		String niNo = scan.nextLine();
		
		System.out.print("\nPlease enter the employee's Bank Account IBAN/BIC: ");
		String iban = scan.nextLine();
		
		System.out.print("\nPlease enter the employee's starting salary: ");
		float salaryStart = Float.parseFloat(scan.nextLine());
		
		
		System.out.println("\nPlease chose from one of the following departments: "
				+ "\n  1 - Digital Services"
				+ "\n  2 - Systems"
				+ "\n  3 - Smart"
				+ "\n  4 - Evolve\n");
		
		int departmentID = Integer.parseInt(scan.nextLine());
		String department = "";
		
		switch(departmentID) {
			case(1): department = "Digital Services"; break;
			case(2): department = "Systems"; break;
			case(3): department = "Smart"; break;
			case(4): department = "Evolve"; break;
			default: System.out.println("Invalid Department... Exiting program."); System.exit(0);
		}
		
		String confirm = String.format("\n\nIs the following information all correct?:"
				+ "\n\nName:                   %s %s"
				+ "\n\nAddress:              %s"
				+ "\nNational Insurance No:  %s"
				+ "\nBank Account No:        %s"
				+ "\nStarting Salary:        $%.2f"
				+ "\nDepartment:             %s"
				+ "\n\nPlease enter 'y' to continue: ",
				fName, lName, address, niNo, iban, salaryStart, department);
		
		System.out.print(confirm);
		
		String input = scan.nextLine();
		
		if(input.toLowerCase().equals("y")) {
			
			Employee newEmployee = new Employee(1, salaryStart, fName, lName, niNo, iban, address, departmentID);
			
			try {
				Connection c = DriverManager.getConnection("jdbc:mysql://localhost/world","conor", "password");
				newEmployee.sendToDb(c);
			}catch(Exception e) {
				System.out.println("Failed to connect to db: " + e);
			}
			
		}else {
			System.exit(0);
		}
		
		
	}
}
