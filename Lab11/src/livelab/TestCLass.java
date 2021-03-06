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

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestCLass {
	public static void main(String[] arg) throws SQLException {
		WS11 test = new WS11();
		
		Connection conn = test.connect();
		Statement stmt = conn.createStatement();
		
		Student abc = new Student("abc", "p1", "Kyle Wright", "a@senencacollege.ca");
		Student cde = new Student("cde", "p2", "Yao Mi", "c@senecacollege.ca");
		Student wbc = new Student("wbc", "p3", "Jack Jill", "a@senencacollege.ca");
		
		System.out.println("Lab 11 Start");
		System.out.println("---------------------------------------");
		System.out.println("Initializing tables");
		
		test.dropTable();
		test.createTable();
		
		test.arJACStudents(stmt, abc);
		test.arJACStudents(stmt, cde);
		test.arJACStudents(stmt, wbc);
		
		test.arAssignedExercises(stmt, "a@senencacollege.ca", "e1", 10);
		test.arAssignedExercises(stmt, "a@senencacollege.ca", "e2", 10);
		test.arAssignedExercises(stmt, "c@senecacollege.ca", "e1", 4);
		test.arAssignedExercises(stmt, "c@senecacollege.ca", "e4", 20);
		
		test.arJACLogs(stmt, "abc", "e1", 9, 1);
		test.arJACLogs(stmt, "wbc", "e2", 7, 1);
		
		test.showJACStudents();
		test.showExerciseAssigned();
		test.showAGSLog();
		
		System.out.println("\nPress enter to continue");		
		pause();
		System.out.println("JACLogs after the Program runs ");
		test.noSubmit();
		test.showAGSLog();
		System.out.println("------------------------------");
		System.out.println("DONE!");
		
	}
	
	public static void pause() { //pauses application
		@SuppressWarnings("resource")
		Scanner o = new Scanner(System.in);
		@SuppressWarnings("unused")
		String temp = null;
		
		temp = o.nextLine();
	}
}
