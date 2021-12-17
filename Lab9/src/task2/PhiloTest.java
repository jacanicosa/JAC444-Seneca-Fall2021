/**********************************************
Workshop 9
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:29 November 2021
**********************************************/
package task2;

public class PhiloTest {
	public static void main(String[] arg) {
		final int numMembers = 5;
		final Philosopher[] members = new Philosopher[numMembers];
		Object[] chopsticks = new Object[numMembers];
		for(int i = 0; i < chopsticks.length; i++) {
			chopsticks[i] = new Object();
		}
		
		
		for(int i = 0; i < members.length - 1; i++) {
			members[i] = new Philosopher(chopsticks[i], chopsticks[i+1]);
		}
		
		
		members[members.length-1] = new Philosopher(chopsticks[chopsticks.length-1], chopsticks[0]);
		
		for(int i = 0; i < members.length; i++) {
			Thread eat = new Thread(members[i], "Philosopher " + (i+1) + " ");
			eat.start();
		}
	}
}
