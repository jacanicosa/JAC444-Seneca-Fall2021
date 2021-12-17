/**********************************************
Workshop 2
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:03 October 2021
**********************************************/

package saleslip;

import java.util.Random;


public class SaleSlipTester {
	private static final Random randomNumbers = new Random();

	public static void main(String[] args) {

		SaleSlip saleslip = new SaleSlip();
		
		for (int i=0; i <100; i++) {
		saleslip.setPerson(randomNumbers.nextInt(4));
		saleslip.setProduct(randomNumbers.nextInt(5));
		saleslip.setValue(randomNumbers.nextInt(1000));
		saleslip.setElements(saleslip.getPerson(), saleslip.getProduct(), saleslip.getValue());
		saleslip.total(saleslip.getSales());
		}
		
	}

}
