/**********************************************
Workshop 4
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:17 October 2021
**********************************************/
package employees;

import payableinterface.Employee;

public class SalariedEmployee extends Employee {
	private double weeklySalary;
	
	public SalariedEmployee(String first, String last, String ssn,
			double salary) {
		super(first, last, ssn);
		setWeeklySalary(salary);
		
	}
	
	public void setWeeklySalary(double salary) {
		weeklySalary = salary<0.0?0.0:salary;
	}
	public double getWeeklySalary() {
		return weeklySalary;
	}
	
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
	public String toString() {
		return String.format("salaried employee: %s\n%s: $%,.2f",
				super.toString(), "weekly salary", getWeeklySalary() );
	}

}
