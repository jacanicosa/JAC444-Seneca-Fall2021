package task1;
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
import java.util.Scanner;

public class Task1Test {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Task1 ed = new Task1();

        int value = requestInput("Enter a 4 digit number for encryption: ", sc);

        while(ed.validate(value) != true){
            value = requestInput("Enter a 4 digit number for encryption: ", sc);
        }
        int encrypted = ed.encrypt(value);
        int decrypted = ed.decrypt(encrypted);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
    public static int requestInput(String s, Scanner sc){
        System.out.print(s);
        return sc.nextInt();
    }
}
