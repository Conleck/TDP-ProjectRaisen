package employee_stuff;

public class Employee implements IPlayable{
	private int number;
	private float salary;
	private String name;
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
	
	public Employee(int number, float salary, String name) {
		this(number, salary);
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee emp = (Employee) obj;
			return this.getNumber() == emp.getNumber()
					&& this.getName() == emp.getName()
					&& this.getSalary() == emp.getSalary();
		} else return false;
	}
	
	@Override
	public String toString() {
		String message =
				String.format("Employee %d: %s, $%.2f. "
						+ "Monthly gross pay: $%.2f.", 
						getNumber(), getName(), getSalary(), calcPay());
		return message;
	}
	
	public float calcPay() {
		return getSalary()/12;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


