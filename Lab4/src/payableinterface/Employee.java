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

public abstract class Employee implements Payable {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String first, String last, String ssn) {
		firstName=first;
		lastName=last;
		socialSecurityNumber=ssn;
	}
	
	public void setFirstName(String first) {
		firstName=first;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String last) {
		lastName=last;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber=ssn;
	}
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public String toString() {
		return String.format("%s %s\nsocial security number: %s",
				getFirstName(), getLastName(), getSocialSecurityNumber() );
	}

}
