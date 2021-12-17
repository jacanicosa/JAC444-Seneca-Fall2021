package guessgame;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class GuessingGameGUI extends JFrame{
    
    
	private static final long serialVersionUID = -7368236556372119402L;
	private final JPanel mainPanel;
    private final JPanel upperPanel;
    private final JPanel lowerPanel;
    private final JTextField textInputField;
    private final JLabel textInputLabel;
    private final JLabel outputResultLabel;
    private final JButton playAgainButton;
    private final JButton guessButton;
    
    private int chosenNumber;
    private int smallestDistance;
    private int largestDistance;
    private int currentDistance;
    
    private boolean isFirstGuess = true;
    
    private char backgroundColourIndicator;
    
    private final String initialMessage = "I have a number between 1 and 1000. <br>Can you guess my number?" +
                                            "<br>Please enter your first guess.";
    
    public GuessingGameGUI(){
        
        this.chosenNumber =  GuessingGameGUI.pickNumber(); 
        
        
        textInputField = new JTextField(""); 
        textInputLabel = new JLabel("Enter guess value:"); 
        outputResultLabel = new JLabel(""); 
        playAgainButton = new JButton("Click to Play Again");
        guessButton = new JButton("Enter Guess");
        
        outputResultLabel.setText("<html>"+ initialMessage  + "</html>");
        
        upperPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout());
        upperPanel.add(outputResultLabel);
        
        lowerPanel = new JPanel();
        lowerPanel.setLayout(new GridLayout(2, 2, 5, 5));
        lowerPanel.add(textInputLabel);
        lowerPanel.add(textInputField);
        lowerPanel.add(playAgainButton);
        lowerPanel.add(guessButton);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(upperPanel, BorderLayout.NORTH);
        mainPanel.add(lowerPanel, BorderLayout.SOUTH);

        add(mainPanel);
        
        guessButton.addActionListener(new ActionListener(){    
            
            public void actionPerformed(ActionEvent e){ 
                
                String tooHigh = "Too high, try again.";
                String tooLow = "Too low, try again.";
                String correct = "Congratulations. You guessed the number!";
                String result = "";
                
                int theGuessedNumber = Integer.parseInt(textInputField.getText());
                
                findCurrentDistance(chosenNumber, theGuessedNumber);
    
                if(isFirstGuess){
                    
                    setSmallestDistance(getCurrentDistance());
                    
                    setIsFirstGuess(false);
                }
                
                setLargestAndSmallest();
                
                outputResultLabel.setOpaque(true);
                upperPanel.setOpaque(true);
                
                
                if(getBackgroundColourIndicator() == 'b'){
                    outputResultLabel.setBackground(Color.blue);
                    upperPanel.setBackground(Color.blue);
                }
                else if(getBackgroundColourIndicator() == 'r'){
                    outputResultLabel.setBackground(Color.red);
                    upperPanel.setBackground(Color.red);
                }
                
                if(theGuessedNumber == chosenNumber){
                    outputResultLabel.setBackground(Color.green);
                    upperPanel.setBackground(Color.green);
                    textInputField.setEditable(false);
                    result = correct;
                }
                else if (theGuessedNumber < chosenNumber){
                    result = tooLow;
                }
                else if (theGuessedNumber > chosenNumber){
                    result = tooHigh;
                }

                outputResultLabel.setText(result);  
            
            }  
        });

        
        playAgainButton.addActionListener(new ActionListener(){    
            
            public void actionPerformed(ActionEvent e){ 
                
                GuessingGameGUI.pickNumber();
                
                outputResultLabel.setText("<html>"+ initialMessage  + "</html>");
                
                textInputField.setEditable(true);
                
                textInputField.setText("");
            
            }  
        });
        

    }

    public int getChosenNumber() {
        return chosenNumber;
    }

    public void setChosenNumber(int chosenNumber) {
        this.chosenNumber = chosenNumber;
    }

    public int getSmallestDistance() {
        return smallestDistance;
    }

    public void setSmallestDistance(int smallestDistance) {
        this.smallestDistance = smallestDistance;
    }

    public int getLargestDistance() {
        return largestDistance;
    }

    public void setLargestDistance(int largestDistance) {
        this.largestDistance = largestDistance;
    }

    public int getCurrentDistance() {
        return currentDistance;
    }

    public void setCurrentDistance(int currentDistance) {
        this.currentDistance = currentDistance;
    }

    public boolean isIsFirstGuess() {
        return isFirstGuess;
    }

    public void setIsFirstGuess(boolean isFirstGuess) {
        this.isFirstGuess = isFirstGuess;
    }

    public char getBackgroundColourIndicator() {
        return backgroundColourIndicator;
    }

    public void setBackgroundColourIndicator(char backgroundColourIndicator) {
        this.backgroundColourIndicator = backgroundColourIndicator;
    }
    
    public static int pickNumber(){

        Random randomNumber = new Random();
        int number = 1 + randomNumber.nextInt(1000);

        return number;
    }
    
    public void setLargestAndSmallest(){

      
        if(getCurrentDistance() < getSmallestDistance()){
            
            setLargestDistance(getSmallestDistance());
            
            setSmallestDistance(getCurrentDistance());
            
            setBackgroundColourIndicator('b');
        }
      
        else if((getCurrentDistance() > getSmallestDistance()) && (getCurrentDistance() < getLargestDistance())){
            setSmallestDistance(getCurrentDistance());
            setBackgroundColourIndicator('r');
        }
    
        else if((getCurrentDistance() > getSmallestDistance()) && (getCurrentDistance() > getLargestDistance())){
            setLargestDistance(getCurrentDistance());
            setBackgroundColourIndicator('r');
        }

    }
    
    public void findCurrentDistance(int chosenNumber, int guessedNumber){
        
        int distance = 0;
              
        if(chosenNumber > guessedNumber){
            
            distance = chosenNumber - guessedNumber;
            
        }
        else if(chosenNumber < guessedNumber){
            
            distance = guessedNumber - chosenNumber;
            
        }
        else{
            
            distance = 0;
            
        }
        setCurrentDistance(distance);
   
    }
    

}

