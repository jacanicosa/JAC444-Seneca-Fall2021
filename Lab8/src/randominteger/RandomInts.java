/**********************************************
Workshop 8
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:24 November 2021
**********************************************/
package randominteger;
import java.util.*;
import java.util.ArrayList;

public class RandomInts {
	  public static void main(String args[]) {

	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i = 0; i < 25; i++) {
	            int randomInt = (int) (100.0 * Math.random());
	            list.add(randomInt);

	        }
	        Collections.sort(list);
	        int averageScore = 0;
	        int totalScore = 0;
	        for (int i = 0; i < list.size(); i++) {
	            totalScore += list.get(i);
	        }
	        averageScore = totalScore / list.size();
	        System.out.println("Array of random integers between 1 and 100 : " + list);
	        System.out.println("Sum of random array values : " + totalScore);
	        System.out.println("Average of random array values : " + averageScore);

	    }
}
