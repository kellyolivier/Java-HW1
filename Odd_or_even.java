import java.util.Scanner;
import java.util.Random;

public class Odd_or_even {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number between 10 and 100: ");
        int input = scanner.nextInt();
        //PT -- check the input in 10-100. -2
        
        //loop based on number of ints that user wants tested
        for(int i = 0; i < (input); i++)
        {
            //create random number for this time through loop
            Random random = new Random();
            int randNum = random.nextInt(200);
            
            //test for even or odd based on divisibility by 2
            if(randNum % 2 == 0)
            {
                System.out.print(randNum);
                System.out.println(" is even.");
                
            }
            else
            {
                System.out.print(randNum);
                System.out.println(" is odd.");
                
            }
        }
        
        scanner.close();
    }
}
