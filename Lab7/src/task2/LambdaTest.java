/**********************************************
Workshop 7
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:15 November 2021
**********************************************/

package task2;

import java.util.Arrays;
import java.util.Scanner;

public class LambdaTest {
	public static final ArrayProcessor max = (ap) -> {
		Arrays.sort(ap);
		return ap[ap.length - 1];
	};
	
	public static final ArrayProcessor min = (ap) -> {
		Arrays.sort(ap);
		return ap[0];
	};
	
	public static final ArrayProcessor sum = (ap) -> {
		double sum = 0;
		for(int i = 0; i < ap.length; i++) {
			sum += ap[i];
		}
		
		return sum;
	};
	
	public static final ArrayProcessor avr = (ap) -> {
		return (sum.apply(ap) / ap.length);
	};
	
	public static ArrayProcessor counter(double value) {
		ArrayProcessor count = (ap) -> {
			int innerCount = 0;
			for(int i = 0; i < ap.length; i++) {
				if(ap[i] == value) {
					innerCount++;
				}
			}
			return innerCount;
		};
		
		return count;
	}
	
	public static void main(String[] arg) {
		double[] arrTest = getArray();
		double dbl = 0;
		System.out.print("The " + arrTest.length + " numbers in the array are: ");
		for(int i = 0; i < arrTest.length; i++) {
			System.out.print(arrTest[i] + ", ");
		}
		System.out.print("\n");
		
		System.out.println("The maximum value in the array is: " + max.apply(arrTest));
		System.out.println("The minimum value in the array is: " + min.apply(arrTest));
		System.out.println("The sum value in the array is: " + sum.apply(arrTest));
		System.out.println("The average value in the array is: " + avr.apply(arrTest));
		
		System.out.print("Enter a double value: ");
		dbl = getDouble();
		
		System.out.println("The number of times " + dbl + " has appeared in arrTest is: " + counter(dbl).apply(arrTest));
		
	}
	
	public static double[] getArray() {
		
		System.out.print("Enter list: ");
		
		double[] arr = {};
		
		String numString = getString();
		
		String[] numStringSplit = numString.split(" ");
		try {
			arr = new double[numStringSplit.length];
			
			for(int i = 0; i < numStringSplit.length; i++) {
				arr[i] = Double.parseDouble(numStringSplit[i]);
			}
		} catch(Exception e) {
			System.out.println("Please enter a list of doubles with spaces between");
		}

		return arr;
	}
	
	public static String getString() {
		Scanner scan = new Scanner(System.in);
		String string = scan.nextLine();
		return string;
		
	}
	
	public static double getDouble() {
		double dbl = 0;
		Scanner scan = new Scanner(System.in);
		try {
			dbl = scan.nextDouble();
		}catch(Exception e) {
			System.out.println("Please enter a double.");
		}
		scan.close();
		return dbl;
	}
}