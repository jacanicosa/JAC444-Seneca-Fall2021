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
package task1;

public class MultiplyTest {

	public static void main(String[] args) {
		long start = 0;
		long end = 0;
		
		int squareSize = 2000;
		
		double[][] testA = MultiplyMatrix.randomMatrix(squareSize, squareSize);
		double[][] testB = MultiplyMatrix.randomMatrix(squareSize, squareSize);
		
		System.out.println("Multiplying 2000 by 2000 matrices using sequential method.");
		System.out.println("----------------------------------------------------------");
		start = System.currentTimeMillis();
		double[][] testC = MultiplyMatrix.sequentialMultiplyMatrix(testA, testB);
		end = System.currentTimeMillis();
		
		System.out.println("\nProcess done.\nThe time it took to multiply 2000 by 2000 matrices "
				+ "using sequential method is: " + (end - start) + "ms");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Multiplying 2000 by 2000 matrices using parallel method.");
		System.out.println("--------------------------------------------------------");
		
		start = System.currentTimeMillis();
		double[][] testD = MultiplyMatrix.parallelMultiplyMatrix(testA, testB);
		end = System.currentTimeMillis();
		
		System.out.println("\nProcess done.\nThe time it took to multiply 2000 by 2000 matrices "
				+ "using parallel method is: " + (end - start) + "ms\n");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("END");
	}

}
