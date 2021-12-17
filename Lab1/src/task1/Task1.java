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
public class Task1 {
	public boolean validate(int value){
        return (Integer.toString(value).length() == 4) ? true : false;
    }
    public int encrypt(int value){
        int arrValue[] = new int[4];
        for(int i=3; i>=0; i--){
            arrValue[i] = value % 10;
            value /= 10;
        }

        arrValue = swapDigits(arrValue);

        for(int i=0; i<4; i++){
            arrValue[i] = (arrValue[i] + 7) % 10;
        }

       return toInt(arrValue);
    }
    public int decrypt(int value){
        int arrValue[] = new int[4];
        for(int i=3; i>=0; i--){
            arrValue[i] = value % 10;
            value /= 10;
        }

        arrValue = swapDigits(arrValue);

        for(int i=0; i<4; i++){
            arrValue[i] = (((arrValue[i] + 10) - 7) % 10);
        }

        return toInt(arrValue);
    }

    private int[] swapDigits(int[] arrValue){
        
        int tempValue = arrValue[0];
        arrValue[0] = arrValue[2];
        arrValue[2] = tempValue;

        tempValue = arrValue[1];
        arrValue[1] = arrValue[3];
        arrValue[3] = tempValue;

        return arrValue;
    }

    private int toInt(int[] arrValue){
        
        StringBuilder temp = new StringBuilder();

        for(int i=0; i<arrValue.length; i++){
            temp.append(arrValue[i]);
        }

        return Integer.parseInt(temp.toString());
    }
	
}


