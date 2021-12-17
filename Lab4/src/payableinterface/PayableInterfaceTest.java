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
package payableinterface;

import employees.BasePlusCommissionEmployee;
import employees.CommissionEmployee;
import employees.HourlyEmployee;
import employees.SalariedEmployee;

public class PayableInterfaceTest {
	public static void main( String args[] ) {
		Payable payableObjects[] = new Payable[ 6 ];
		
		payableObjects[ 0 ] = new Invoice( "01234", "Shirt", 9, 89.00 );
		payableObjects[ 1 ] = new Invoice( "56789", "Boots", 6, 129.95 );
		payableObjects[ 2 ] =
				new SalariedEmployee( "Thierry", "Henry", "109-20-9808", 544000.00 );
		payableObjects[ 3 ] =
				new HourlyEmployee( "Patrick", "Viera", "098-22-5467", 24000.00 , 40);
		payableObjects[4] =
				 new CommissionEmployee(  
						 "Dennis",  "Bergkamp", "299-31-5771", 3000000, .15 );
		payableObjects[5] =
				new BasePlusCommissionEmployee(
						"Arsene", "Wenger", "192-42-2345", 800000, .20, 30000 );  
		
		System.out.println("Invoices and Employees processed polymorphically:\n");
		
		for ( Payable currentPayable : payableObjects ) {
			System.out.printf( "%s \n%s: $%,.2f\n\n",
					currentPayable.toString(),
					"payment due", currentPayable.getPaymentAmount());
		}
		
	}

}
