package employee_stuff;

public class PayrollSystem {
	
	private float taxRate = 0.25f;
	
	public float netPay(IPlayable payee) {
		float grossPay = payee.calcPay();
		float taxToPay = grossPay * taxRate;
		return grossPay - taxToPay;
	}

}
