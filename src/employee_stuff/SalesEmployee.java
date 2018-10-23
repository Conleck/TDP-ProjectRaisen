package employee_stuff;

public class SalesEmployee extends Employee {
	private float commisionRate;
	private float salesTotal = 0;
	
	public SalesEmployee(int number, float salary, String name, float commisionRate){
		super(number, salary, name);
		this.commisionRate = commisionRate;
	}
	
	public SalesEmployee(int number, float salary, String name, float commisionRate, float salesTotal){
		this(number, salary, name, commisionRate);
		this.salesTotal = salesTotal;
	}
	
	@Override
	public float calcPay() {
		return super.calcPay() + (commisionRate * salesTotal);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof SalesEmployee) {
			SalesEmployee emp = (SalesEmployee) obj;
			return this.getCommisionRate() == emp.getCommisionRate()
					&& this.getSalesTotal() == emp.getSalesTotal()
					&& super.equals(obj);
		} else return false;
	}
	
	@Override
	public String toString() {
		String message =
				String.format("SalesEmployee %d: %s, $%.2f. "
						+ "Monthly gross pay(post commission): $%.2f. "
						+ "Commision Rate: %.2f. Sales Total: %.2f.", 
						getNumber(), getName(), getSalary(), calcPay(), 
						getCommisionRate(), getSalesTotal());
		return message;
	}
	
	public float getCommisionRate() {
		return commisionRate;
	}
	
	public void setCommisionRate(float commisionRate) {
		this.commisionRate = commisionRate;
	}

	public float getSalesTotal() {
		return salesTotal;
	}

	public void setSalesTotal(float salesTotal) {
		this.salesTotal = salesTotal;
	}
}
