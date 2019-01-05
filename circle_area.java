import java.util.Scanner;

public class circle_area {
	 public static void main(String[] args){
		 final double PI = 3.14;
		 Scanner scan = new Scanner(System.in);
		 
		 System.out.println("Please enter the radius of a circle: ");
		 int input = scan.nextInt();
		 
		 System.out.print("The area of the circle is: ");
		 System.out.println(PI*input*input);
		 
		 
		 scan.close();
	 }
}