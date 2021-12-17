/**********************************************
Workshop 2
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:03 October 2021
**********************************************/
package saleslip;


public class SaleSlip {
	
	private double[][] sales;
	private int Person;
	private int Product;
	private double Value;
	
	public SaleSlip() {
		this.sales = new double[4][5];
	}
	public double[][] getSales() {
		return sales;
	}

	public void setSales(double[][] sales) {
		this.sales = sales;
	}
	
	public void setElements(int i, int j, double value) {
		this.sales[i][j] += value;
	}

	public int getProduct() {
		
		return Product;
	}

	public void setProduct(int product) {
		this.Product = product;
	}

	public int getPerson() {
		return Person;
	}

	public void setPerson(int Person) {
		this.Person = Person;
	}

	public double getValue() {
		return Value;
	}

	public void setValue(double value) {
		this.Value = value;
	}
	
	public void display() {
		int i=0;
      		for (double[] ds : sales) {
          		System.out.print(++i+"\t");
          		for (double d : ds) System.out.printf(d + "\t");
          		System.out.println("");
      		}
	}
	public void total(double sales[][]) {
		double totalSales;
    double[] productSales = new double[sales[0].length];
    System.out.println("|Sales | \t\tProducts   \t\t\t     |");
    for (int i = 1; i<= sales[0].length+2; i++) System.out.printf("-------%s ","+"); 
    System.out.println("");
    System.out.print("|Person|");
    for (int i = 1; i<= sales[0].length; i++) System.out.printf("%8d|",i); 
    System.out.print(" Total  |");
    System.out.println(""); 
    for (int i = 1; i<= sales[0].length+2; i++) System.out.printf("-------%s ","+");
    System.out.println("");
    for (int i = 0; i < sales.length; i++) {
        totalSales = 0.0;
        System.out.printf("| %4d |", i + 1);
        for (int j = 0; j < sales[0].length; j++) {
            totalSales += sales[i][j];
            productSales[j] += sales[i][j];
            System.out.printf("%8.2f|", sales[i][j]);
        }
        System.out.printf("%8.2f|\n", totalSales);
    }
    for (int i = 1; i<= sales[0].length+2; i++) System.out.printf("-------%s ","+");
    System.out.println("");
    System.out.print("| Total|");
    for (double s : productSales) System.out.printf("%8.2f|", s);
    System.out.println("");
    for (int i = 1; i<= sales[0].length+1; i++) System.out.printf("-------%s ","+");
    System.out.println("");
} 

}
