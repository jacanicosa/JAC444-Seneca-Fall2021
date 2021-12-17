package craps;
/**********************************************
Workshop 1
Course:JAC444 - Fall 2021
Last Name:Canicosa
First Name:Albert Joshua
ID:144404191
Section:NFF
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date:26 September 2021
**********************************************/
import java.util.Random;


public class Crapsv1 {
	 private static final Random randomNumbers = new Random();
	    
	    private enum Status {Win, Lose, Draw};
	    
	    
	    public static void main(String[] args) {
	        int myPoint =0; 
	        Status gameStatus;  
	         int point = rollDice(); 
	        
	                switch (point){
	                    case 7:  
	                    case 11: 
	                        gameStatus = Status.Win;
	                        break;
	                    case 2: 
	                    case 3:     
	                    case 12: 
	                        gameStatus = Status.Lose;
	                        break;
	                    default: 
	                        gameStatus = Status.Draw;
	                        myPoint = point;   
	                        System.out.printf("Point is (established) set to %d\n", myPoint);
	                        break; 
	                }
	        
	                while(gameStatus==Status.Draw){               
	                    point = rollDice(); 
	                   
	                    if (point == myPoint)  
	                        gameStatus =Status.Win;
	                    else
	                        if(point ==7)  
	                            gameStatus = Status.Lose;
	                }
	        
	                if (gameStatus ==Status.Win){
	                    System.out.println("Congratulations, You win\n");
	            
	                }
	                else {
	                    System.out.println("Craps, Better Luck Next Time, You lose\n");
	              
	                }  
	            }
	        

	    public static int rollDice() {
	        int die1 = 1 + randomNumbers.nextInt(6);  
	        int die2 = 1 + randomNumbers.nextInt(6); 
	        int sum = die1 + die2;
	        
	       
	        System.out.printf("You rolled %d + %d = %d\n", die1,die2,sum);
	        
	        return sum; 
	    }

}
