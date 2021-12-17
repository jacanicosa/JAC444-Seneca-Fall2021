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
package primenumbers;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Scanner;



public class Prime {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number, please!");
        int number = input.nextInt();
        SortedSet<Integer> factors = new TreeSet<>();
        int c = 2;
        boolean flag = false;

        while (c < number) {

            flag = false;

            if ((number % c) == 0) {

                if (factors.isEmpty())
                    factors.add(c);

                else {
                    for (Integer integer : factors) {
                        if (c % integer == 0)
                            flag = true;
                    }

                    if(flag == false)
                        factors.add(c);
                }
            }
            c++;

        }


        if (factors.size() == 0)
            System.out.printf("%d is a prime number!", number);
        else
            System.out.print("Factors: ");
        for (Integer integer : factors)
            System.out.printf("%d ", integer);
    }
}