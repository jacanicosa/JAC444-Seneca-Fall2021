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

public class AccountRecord {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	public AccountRecord() {
		this(0,"","",0.0);
	}
	
	public AccountRecord(int acct, String first, String last, double bal){
		setAccount(acct);
		setFirstName(first);
		setLastName(last);
		setBalance(bal);
	}
	
	public void combine(TransactionRecord transaction) {
		balance=balance+transaction.getAmount();
	}
	public void setAccount(int acct) {
		account =acct;
		
	}
	public int getAccount() {
		return account;
	}
	
	public void setFirstName(String first) {
		firstName =first;
		
	}
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String last) {
		lastName =last;
		
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setBalance(double bal) {
		balance =bal;
		
	}
	public double getBalance() {
		return balance;
	}
}
