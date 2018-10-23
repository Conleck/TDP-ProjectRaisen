package app;
import employee_stuff.*;
import java.sql.*;

public class Hello {
	public static void main(String[] args) {
		Employee emp1 = new Employee(10, 15000.00f, "A. Smith");
		System.out.println(emp1);
		
		SalesEmployee emp2 = new SalesEmployee(10, 15000.00f, "A. Smith", 0.015f, 100000);
		System.out.println(emp2);			
		
		PayrollSystem ps = new PayrollSystem();
		float emp1_pay = ps.netPay(emp1);
		float emp2_pay = ps.netPay(emp2);
		
		
	
		
		
		///////////
		
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
		
		
	}
}
