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

import java.util.ArrayList;
import java.util.Random;

public class MultiplyMatrix { 
	
	private static double[][] temp1;
	private static double[][] temp2;
	
	MultiplyMatrix(){
		setTemp1(randomMatrix(0, 0));
		setTemp2(randomMatrix(0, 0));
	}
	
	MultiplyMatrix(double[][] src1, double[][] src2){
		setTemp1(src1);
		setTemp2(src2);
	}
	
	public static double[][] sequentialMultiplyMatrix(double[][] a, double[][] b){
		double[][] axb = new double[a.length][b[0].length]; 
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b[0].length; j++) { 
				for(int k = 0; k < a[0].length; k++) { 
					axb[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return axb;
	}
	
	public static double[][] parallelMultiplyMatrix(double[][] a, double[][] b){ 
		double[][] axb = new double[a.length][b[0].length];
		
		setTemp1(a);
		setTemp2(b);
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Thread thread = new Thread() {
			public void run() {
				for(int i = 0; i < a.length/4; i++) { 
					for(int j = 0; j < b[0].length; j++) { 
						for(int k = 0; k < a[0].length; k++) { 
							axb[i][j] += a[i][k] * b[k][j];
						}
					}
				}
			}
		};
		thread.start();
		threads.add(thread);

		thread = new Thread() {
			public void run() {
				for(int i = a.length/4; i < a.length/2; i++) { 
					for(int j = 0; j < b[0].length; j++) {
						for(int k = 0; k < a[0].length; k++) {
							axb[i][j] += a[i][k] * b[k][j];
						}
					}
				}
			}
		};
		thread.start();
		threads.add(thread);
		
		thread = new Thread() {
			public void run() {
				for(int i = a.length/2; i < 3*a.length/4; i++) { 
					for(int j = 0; j < b[0].length; j++) {
						for(int k = 0; k < a[0].length; k++) {
							axb[i][j] += a[i][k] * b[k][j];
						}
					}
				}
			}
		};
		thread.start();
		threads.add(thread);
		
		thread = new Thread() {
			public void run() {
				for(int i = 3*a.length/4; i < a.length; i++) { 
					for(int j = 0; j < b[0].length; j++) { 
						for(int k = 0; k < a[0].length; k++) { 
							axb[i][j] += a[i][k] * b[k][j];
						}
					}
				}
			}
		};
		thread.start();
		threads.add(thread);
		
		for(Thread thr : threads) {
			try {
				thr.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return axb;
	}
	
	public static void displayMatrix(double[][] src) {
		for(int i = 0; i < src.length; i++) {
			for(int k = 0; k < src[0].length; k++) {
				System.out.print(src[i][k] + "  ");
			}
			System.out.print("\n");
		}
	}
	
	public static double[][] randomMatrix(int row, int column){
		Random rand = new Random();
		double[][] mat = new double[row][column];
		
		for(int i = 0; i < row; i++) {
			for(int k = 0; k < column; k++) {
				mat[i][k] = rand.nextDouble();
			}
		}
		
		return mat;
	}

	public double[][] getTemp1() {
		return temp1;
	}

	public static void setTemp1(double[][] src) {
		temp1 = src;
	}

	public double[][] getTemp2() {
		return temp2;
	}

	public static void setTemp2(double[][] src) {
		temp2 = src;
	}
}
