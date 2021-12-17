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
import java.util.Scanner;

public class Crapsv2 {
    
    private static final Random randomNumbers = new Random();
    private enum Status {Win, Lose, Draw};
    

	public static void main(String[] args) {
        int Balance =1000;
        int wager  =0;
        int myPoint =0; 
		Scanner input = new Scanner (System.in);
	
        
        
        do{                           
            System.out.printf("Bank Balance: %d\n", Balance);
            if (Balance <=0){
                System.out.println("Sorry. You busted!");
                break;
            }
        
            System.out.print("Please Enter a wager(0=End): ");
            wager = input.nextInt();
            
        
            if (Balance < wager){
                System.out.println("Wager Can not exceed Bank Balance");
                continue;
            }
            else 
            	
            
                if (wager ==0) {
                	System.out.println("Thank you for playing!");
                    break;
                }
                else{
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
                    System.out.println("Congratulations, You win");
                    System.out.println(chatterW());
                   Balance += wager;
                }
                else {
                    System.out.println("Craps, Better Luck Next Time, You lose");
                    System.out.println(chatterL());
                   Balance -= wager;
                }  
            }
        
        }while(wager!=0);
        	input.close();    
    } 
    

	public static int rollDice()
    {
        int die1 = 1 + randomNumbers.nextInt(6);  
        int die2 = 1 + randomNumbers.nextInt(6); 
        int sum = die1 + die2;
        
       
        System.out.printf("You rolled %d + %d = %d\n", die1,die2,sum);
        
        return sum; 
    }
	public static String chatterW() {
		switch (randomNumbers.nextInt(5))
		{
		case 0:
			return "Nice one!\n";
		case 1:
			return "You're on a roll!\n";
		case 2:
			return "You're up big. Now's the time cash in your chips!\n";
		case 3:
			return "Someone's feeling lucky today!\n";
		default:
			return "You gotta teach me how to play, You're way too go at this!\n";
			}
			
		}
		public static String chatterL() {
			switch (randomNumbers.nextInt(5))
			{
			case 0:
				return "Oh, you're going for broke huh?\n";
			case 1:
				return "Don't lose hope, you got this!\n";
			case 2:
				return "I've got a bad feeling about this..\n";
			case 3:
				return "Bad luck!\n";
			default:
				return "Keep playing you'll win next time!\n";
				
			}	
	}
}  
    

