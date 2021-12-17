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


public class Date
 {
 private int day; 
 private int month; 
 private int year; 
 private final String monthNames[] = { "January", "February",
 "March", "April", "May", "June", "July", "August",
 "September", "October", "November", "December" };
 private final int monthDays[] = { 31, 28, 31, 30, 31, 30,
 31, 31, 30, 31, 30, 31 };

// no-argument constructor
 public Date() 
 {
 day = 6;
 month = 10;
 year = 2021;
 } 

 // constructor for first format
 public Date( int mm, int dd, int yyyy )
 {
 setYear( yyyy );
 setMonth( mm );
 setDay( dd );
 } 

 // constructor for format using Month names
 public Date( String mm, int dd, int yyyy )
 {
 setYear( yyyy );
 convertFromMonthName( mm );
 setDay( dd );
 } 

 // constructor for format using days
 public Date( int ddd, int yyyy )
 {
 setYear( yyyy );
 convertFromDayOfYear( ddd );
 } 


 public void setDay( int dd )
 {
 day = ( dd >= 1 && dd <= daysInMonth() ) ? dd : 1;
 }

 
 public void setMonth( int mm )
 {
 month = ( mm >= 1 && mm <= 12 ) ? mm : 1;
} 

 
 public void setYear( int yyyy )
  {
 year = ( yyyy >= 1900 && yyyy <= 2100 ) ? yyyy : 1900;
 }

 
 public String toString()
 {
 return String.format( "%d/%d/%d", month, day, year );
} 


 public String toMonthNameDateString()
 {
 return String.format(
 "%s %d, %d", monthNames[ month - 1 ], day, year );
 } 


 public String toDayDateString()
 {
 return String.format( "%d %d", convertToDayOfYear(), year );
 } 


private int daysInMonth()
 {
 return leapYear() && month == 2 ? 29 : monthDays[ month - 1 ];
 } 


 private boolean leapYear()
 {
 if ( year % 400 == 0 || ( year % 4 == 0 && year % 100 != 0 ) )
 return true;
 else
 return false;
 } 


 private void convertFromDayOfYear( int ddd )
 {
 int dayTotal = 0;

 if ( ddd < 1 || ddd > 366 ) 
 ddd = 1;

 setMonth( 1 );
 
 for ( int m = 1;
 m < 13 && ( dayTotal + daysInMonth() ) < ddd; m++ )
 {
 dayTotal += daysInMonth();
 setMonth( m + 1 );
 }
		 
 setDay( ddd - dayTotal );
} 


 private int convertToDayOfYear()
 {
	 int ddd = 0;

 for ( int m = 1; m < month; m++ )
 {
 if ( leapYear() && m == 2 )
 ddd += 29;
 else
 ddd += monthDays[ m -1 ];
 } 

 ddd += day;
 return ddd;
 } 


 private void convertFromMonthName( String monthName )
 {
 for ( int subscript = 0; subscript < 12; subscript++ )
 {
 if ( monthName.equals( monthNames[ subscript ] ) )
 {
 setMonth( subscript + 1 );
 return; 
 } 
 } 

 setMonth( 1 ); 
 }
 } 