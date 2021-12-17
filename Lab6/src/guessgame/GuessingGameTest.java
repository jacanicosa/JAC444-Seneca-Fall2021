package guessgame;

import javax.swing.JFrame;

public class GuessingGameTest {
   
    public static void main(String[] args) {
        
        GuessingGameGUI guessingGame = new GuessingGameGUI();

        guessingGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        guessingGame.setSize(300, 160);

        guessingGame.setLocation(472, 237);

        guessingGame.setVisible(true);
        
    }
    
}
