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
package dateTask;

import java.util.Scanner;

public class DateTest
 {
 private static Scanner input;

public static void main( String args[] )
 {
 Scanner input = new Scanner( System.in );
 
 int choice = getMenuChoice();

while ( choice != 4 )
 {
 int month; 
 int day; 
 int year; 
 String monthName;
 Date date = new Date();

 switch ( choice )
 {
 case 1:

 System.out.print( "Enter Month (1-12): " );
month = input.nextInt();
System.out.print( "Enter Day of Month: " );
 day = input.nextInt();
 System.out.print( "Enter Year: " );
 year = input.nextInt();

date = new Date( month, day, year );
 break;

 case 2:

 System.out.print( "Enter Month Name: " );
 monthName = input.next();
  System.out.print( "Enter Day of Month: " );
 day = input.nextInt();
 System.out.print( "Enter Year: " );
 year = input.nextInt();

 date = new Date( monthName, day, year );
  break;

 case 3:

System.out.print( "Enter Day of Year: " );
 day = input.nextInt();
 System.out.print( "Enter Year: " );
 year = input.nextInt();

 date = new Date( day, year );
 break;
 } 

 System.out.printf( "\n%s: %s\n%s: %s\n%s: %s\n",
 "MM/DD/YYYY", date.toString(),
 "Month DD, YYYY", date.toMonthNameDateString(),
 "DDD YYYY", date.toDayDateString() );

 choice = getMenuChoice();
 }
input.close();
 } 
 

private static int getMenuChoice()
 {
 input = new Scanner( System.in );
 System.out.println( "Enter 1 for format: MM/DD/YYYY" );
 System.out.println( "Enter 2 for format: Month DD, YYYY" );
 System.out.println( "Enter 3 for format: DDD YYYY" );
 System.out.println( "Enter 4 to exit" );
 System.out.print( "Choice: " );
 return input.nextInt();
 } 
} 