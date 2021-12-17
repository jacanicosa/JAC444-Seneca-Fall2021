/**********************************************
Workshop 5
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:30 October 2021
**********************************************/
package filematching;

public class TransactionRecord {
	private int account;
	private double amount;
	
	public TransactionRecord() {
		this(0,0.0);
	}

	public TransactionRecord(int acct, double amt) {
		setAccount(acct);
		setAmount(amt);
	}
	
	public void setAccount(int acct) {
		account = acct;
		
	}
	public int getAccount() {
		return account;
	}
	
	public void setAmount(double amt) {
		amount = amt;
		
	}
	public double getAmount() {
		return amount;
	}
		

}
