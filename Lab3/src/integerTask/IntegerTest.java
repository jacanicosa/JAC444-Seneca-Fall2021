/**********************************************
Workshop 3
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:09 October 2021
**********************************************/
package integerTask;

public class IntegerTest {
	public static void main(String[] args) {
        MyInteger int1 = new MyInteger(23);
        MyInteger int2 = new MyInteger(53);
        MyInteger int3 = new MyInteger(2);
        MyInteger int4 = new MyInteger(23);

        System.out.printf("%d is prime? %s%n", int1.getValue(), int1.isPrime());
        System.out.printf("%d is prime? %s%n", int2.getValue(), int2.isPrime());
        System.out.printf("%d is prime? %s%n", int3.getValue(), int3.isPrime());

        System.out.printf("%d is even? %s%n", int1.getValue(), int1.isEven());
        System.out.printf("%d is even? %s%n", int2.getValue(), int2.isEven());
        System.out.printf("%d is even? %s%n", int3.getValue(), int3.isEven());

        System.out.printf("93 is odd? %s%n", MyInteger.isOdd(93));
        
        System.out.printf("%d equals %d? %s%n", int1.getValue(), int4.getValue(), int1.equals(int4));

        System.out.printf("the sum of the strings conerted to integer is %d%n", MyInteger.parseInt(new char[] {'1', '2', '3'}));
        System.out.printf("the string converted to integer is %d%n", MyInteger.parseInt("123"));
    }
}
