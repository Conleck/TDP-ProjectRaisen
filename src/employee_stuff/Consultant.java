package employee_stuff;

public class Consultant implements IPlayable{
	public String name;
	public float dailyRate;
	public int daysWorked;
	
	public float calcPay() {
		return dailyRate * daysWorked;
	}
}


