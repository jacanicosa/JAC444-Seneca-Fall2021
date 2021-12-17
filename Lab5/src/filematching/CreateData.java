/**********************************************
Workshop 5
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:30 October 2021
**********************************************/
package filematching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.IllegalFormatException;

public class CreateData {

	public static void main(String[] args) {
		Formatter outOldMaster = null;
		Formatter outTransaction = null;
		AccountRecord accounts[] = new AccountRecord[ 4 ];
		TransactionRecord transactions[] = new TransactionRecord[ 4 ];
		
		accounts[ 0 ] = new AccountRecord( 100, "Alan", "Jones", 348.17 );
		accounts[ 1 ] = new AccountRecord( 300, "Mary", "Smith", 27.19 );
		accounts[ 2 ] = new AccountRecord( 500, "Sam", "Sharp", 0.00 );
		accounts[ 3 ] = new AccountRecord( 700, "Suzy", "Green", -14.22 );
		
		transactions[ 0 ] = new TransactionRecord( 100, 27.14 );
		transactions[ 1 ] = new TransactionRecord( 300, 62.11 );
		transactions[ 2 ] = new TransactionRecord( 400, 100.56 );
		transactions[ 3 ] = new TransactionRecord( 900, 82.17 );
		
		try {
			outOldMaster = new Formatter(new File ( "C:\\Users\\Albert\\eclipse-workspace\\Lab5\\src\\filematchtxt\\oldmast.txt" ));
			
			for ( int i = 0; i < accounts.length; i++ ){
			outOldMaster.format( "%d %s %s %.2f\n",
			accounts[ i ].getAccount(), accounts[ i ].getFirstName(),
			accounts[ i ].getLastName(), accounts[ i ].getBalance() );
			} 
			
			
			outTransaction = new Formatter( new File ( "C:\\Users\\Albert\\eclipse-workspace\\Lab5\\src\\filematchtxt\\trans.txt" ) );
			
			for ( int i = 0; i < transactions.length; i++ ){
			outTransaction.format( "%d %.2f\n",
			transactions[ i ].getAccount(),
			transactions[ i ].getAmount() );
			}
			
		}
		catch ( SecurityException securityException ) {
		System.err.println("You do not have write access to this file." );
		System.exit( 1 );
		}
		
		catch ( FileNotFoundException fileNotFoundException ){
		System.err.println( "Error creating file." );
		System.exit( 1 );
		}
		
		catch ( IllegalFormatException formatException ){
		System.err.println( "Error with output." );
		System.exit( 1 );
		}
		
		catch ( FormatterClosedException closedException ){
		System.err.println("Error writing to file - file has been closed." );
		System.exit( 1 );
		}
		
		finally {
			if ( outOldMaster != null )
				outOldMaster.close();
				
			if ( outTransaction != null )
				outTransaction.close();
			
		}
		
	}

}
