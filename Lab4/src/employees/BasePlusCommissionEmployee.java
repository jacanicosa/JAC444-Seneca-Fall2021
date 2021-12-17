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

public class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary;
	
	public BasePlusCommissionEmployee( String first, String last,
			String ssn, double sales, double rate, double salary ) {
		super( first, last, ssn, sales, rate );
		setBaseSalary( salary );
	}
	
	public void setBaseSalary( double salary ) {
		baseSalary = salary<0.0?0.0:salary;
	}
	
	public double getBaseSalary() {
		return baseSalary;
	}
	
	public double getPaymentAmount() {
		 return getBaseSalary() + super.getPaymentAmount();  	
	}
	
	public String toString() {
		return String.format( "%s %s; %s: $%,.2f",
				"base-salaried", super.toString(),
				"base salary", getBaseSalary() );
				
				
	}

}
