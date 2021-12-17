/**********************************************
Workshop 11
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:13 December 2021
**********************************************/
package livelab;

public class Student {
	private String username;
	private String password;
	private String fullname;
	private String instructorEmail;
	
	public Student(String un, String pw, String fn, String iE) {
		setUsername(un);
		setPassword(pw);
		setFullname(fn);
		setInstructorEmail(iE);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getInstructorEmail() {
		return instructorEmail;
	}

	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
}
