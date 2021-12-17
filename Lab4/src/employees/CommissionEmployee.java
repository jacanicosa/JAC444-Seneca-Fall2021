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

public class CommissionEmployee extends Employee {
	private double grossSales; 
	private double commissionRate; 
	
	public CommissionEmployee( String first, String last, String ssn,
			double sales, double rate ) {
		super( first, last, ssn );
		setGrossSales( sales );
		setCommissionRate( rate );
	}
	
	public void setCommissionRate( double rate ) {
		commissionRate = rate<0.0?0.0:rate;
	}
	
	public double getCommissionRate() {
		return commissionRate;
	}
	
	public void setGrossSales( double sales ) {
		grossSales = sales<0.0?0.0:sales;
	}
	
	public double getGrossSales() {
		return grossSales;
	}
	
	public double getPaymentAmount() {
		return getCommissionRate() * getGrossSales();
	}
	
	  public String toString() {
		  return String.format( "%s: %s\n%s: $%,.2f; %s: %.2f",
				  "commission employee", super.toString(),
				  "gross sales", getGrossSales(),   
				  "commission rate", getCommissionRate() );   
	  }
	

}
