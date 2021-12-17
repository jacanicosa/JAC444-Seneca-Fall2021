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

public class Philosopher implements Runnable{
	private Object left;
	private Object right;
	private static boolean finishEat;
	
	public Philosopher(Object lChop, Object rChop) {
		left = lChop;
		right = rChop;
		setFinishEat(false);
	}
	
	public void action(String src) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + src);
		Thread.sleep((int)(Math.random()*100)); 
		
	}


	public static boolean isFinishEat() {
		return finishEat;
	}


	public static void setFinishEat(boolean finishEat) {
		Philosopher.finishEat = finishEat;
	}

	@Override
	public void run() {
		while(!finishEat) {
			try {
				action("is thinking...");
				synchronized(left) {
					synchronized(right) { 
						action("picks up chopsticks");
						action("is eating");
						finishEat = true;
					}
					action("finished eating");
					action("puts down chopsticks");
				}
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}