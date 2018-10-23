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
		
		System.out.print("\nPlease enter the employee's National Insurance No.: ");
		String niNo = scan.nextLine();
		
		System.out.print("\nPlease enter the employee's Bank Account IBAN/BIC: ");
		String iban = scan.nextLine();
		
		System.out.print("\nPlease enter the employee's starting salary: ");
		float salaryStart = Float.parseFloat(scan.nextLine());
		
		System.out.print("\nPlease enter their employee number: ");
		int empNo = Integer.parseInt(scan.nextLine());
		
		String confirm = String.format("\n\nIs the following information all correct?:"
				+ "\n\nName:                   %s %s"
				+ "\nNational Insurance No:  %s"
				+ "\nBank Account No:        %s"
				+ "\nStarting Salary:        $%.2f"
				+ "\nEmployee No:            %d"
				+ "\n\nPlease enter 'y' to continue: ",
				fName, lName, niNo, iban, salaryStart, empNo);
		
		System.out.print(confirm);
		
		String input = scan.nextLine();
		
		if(!input.toLowerCase().equals("y")) {
			System.out.println(input);
			System.exit(0);
		}
		
		System.out.println("Congratz nerd ur gay");
		
		

		/*
		try {
			Class driver = Class.forName("com.mysql.jdbc.Driver");
			Connection c = 
			      DriverManager.getConnection("jdbc:mysql://localhost/world", 
			            "conor", "password");
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery(
			      "SELECT name, district FROM city ORDER BY RAND() LIMIT 5");
			while(rs.next()){
			   String out = String.format("%s is in %s.", 
			   rs.getString("name"), rs.getString("district"));
			   System.out.println(out);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		*/
	}
}
