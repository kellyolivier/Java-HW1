import java.util.Scanner;

public class string_to_int {
    public static void main(String[] args){
        //initialize scanner and variables
        Scanner scan = new Scanner(System.in);
        boolean isNegative = false;
        int result = 0;
        int currentNum = 0;
        int startDigit=0;
        
        //take user input in string format
        System.out.println("Please enter a number, negatives included:");
        String input = scan.nextLine();
        
        //main for loop to step through every character in the input string
        for(int i = 0; i < input.length(); i++)
        {
            char currentChar = input.charAt(i); 
            //PT -- if (currentChar >= '0' && currentChar < '9')
            if(currentChar >=48 && currentChar <=57)//legal number, based on ascii
            {
                currentNum = currentChar-48; //PT -- -'0'
                result += currentNum;
                if(i >= startDigit && i!=(input.length()-1))
                {
                    result = result*10;
                }
            }
            //PT -- this should only happen on the first character. -1
            else if(currentChar == 45 && i ==0) //handle negative sign at start, but not in middle
            {
                isNegative = true;
                startDigit++;
            }
            else //print error for user
            {
                System.out.println("A non-number character has been entered,program ended.");
            }
        }
        
        //if negative sign found at beginning of input, make result negative
        if(isNegative)
        {
           result = result * -1; 
        }
        
        //display number for debugging, and for user
        System.out.println("Your number is: " + result);     
             
             
        scan.close();    
        }
}
