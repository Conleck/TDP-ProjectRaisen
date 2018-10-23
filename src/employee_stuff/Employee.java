package employee_stuff;

import java.sql.*;

public class Employee implements IPlayable{
	private int number;
	private int departmentID;
	private float salary;
	private String fName;
	private String lName;
	private String niNo;
	private String bankNo;
	private String address;
	private final float MIN_SALARY = 7000.00f;
	
	public Employee() {
		
	}
	
	
	public Employee(int number) {
		this();
		this.number = number;
	}
	
	public Employee(int number, float salary) {
		this(number);
		this.salary = salary;
	}
	
	public Employee(int number, float salary, String fName, String lName, String niNo, String bankNo, String address, int departmentID) {
		this(number, salary);
		this.setfName(fName);
		this.niNo = niNo;
		this.bankNo = bankNo;
		this.address = address;
		this.departmentID = departmentID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp = (Employee) obj;
			return this.getNumber() == emp.getNumber()
					&& this.getfName() == emp.getfName()
					&& this.getlName() == emp.getlName()
					&& this.getSalary() == emp.getSalary();
		} else return false;
	}
	
	@Override
	public String toString() {
		String message =
				String.format("Employee %d: %s, $%.2f. "
						+ "Monthly gross pay: $%.2f.", 
						getNumber(), getfName() + getlName(), getSalary(), calcPay());
		return message;
	}
	
	public float calcPay() {
		return getSalary()/12;
	}
	
	public void sendToDb(Connection c) {
		try {
			Statement st = c.createStatement();
			st.executeUpdate(String.format(
					"INSERT INTO Employee (department_id, first_name, last_name, address, nin, iban, starting_salary) "
					+ "VALUES(%d, %s, %s, %s, %s, %s, %.2f)",
					getDepartmentID(), getfName(), getlName(), getAddress(), getNiNo(), getBankNo(), getSalary()));
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setNumber(String number) {
		try {
			int i = Integer.parseInt(number);
			setNumber(i);
		}catch(Exception e){
			System.out.println("ERROR: Invalid Integer");
		}
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		if(this.salary > MIN_SALARY) {
			this.salary = salary;
		}
	}


	private String getNiNo() {
		return niNo;
	}


	private void setNiNo(String niNo) {
		this.niNo = niNo;
	}


	private String getBankNo() {
		return bankNo;
	}


	private void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}


	private String getAddress() {
		return address;
	}


	private void setAddress(String address) {
		this.address = address;
	}


	private int getDepartmentID() {
		return departmentID;
	}


	private void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}


	private String getfName() {
		return fName;
	}


	private void setfName(String fName) {
		this.fName = fName;
	}


	private String getlName() {
		return lName;
	}


	private void setlName(String lName) {
		this.lName = lName;
	}
}


