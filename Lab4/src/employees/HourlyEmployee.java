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

public class HourlyEmployee extends Employee {
	private double wage;
	 private double hours;
	
	 public HourlyEmployee( String first, String last, String ssn,
			 double hourlyWage, double hoursWorked ){
		super(first, last, ssn);
		setWage( hourlyWage );
		setHours( hoursWorked );
		
	}
	
	public void setWage(double hourlyWage) {
		wage = hourlyWage<0.0?0.0:hourlyWage;
	}
	public double getWage() {
		return wage;
	}
	
	public void setHours(double hoursWorked) {
		if ( ( hoursWorked >= 0.0 ) && ( hoursWorked <= 168.0 ) )
			hours = hoursWorked;
		else
			throw new IllegalArgumentException(
					"Hours worked must be >= 0.0 and <= 168.0" );
	}
	public double getHours() {
		return hours;
	}
	
	public double getPaymentAmount() {
		if ( getHours() <= 40 ) 
			return getWage() * getHours();
		 else  
			 return 40 * getWage() + ( getHours() -  40 ) * getWage() *  1.5 ;
	}
	
	public String toString() {
		return String.format("hourly employee: %s\n%s: $%,.2f; %s: %,.2f",
				super.toString(), "hourly wage" , getWage(),
				"hours worked", getHours() );

				
	}

}
