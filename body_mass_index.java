import java.util.Scanner;


public class body_mass_index {
	 public static void main(String[] args){
		 Scanner scan = new Scanner(System.in);
		 final double poundsToKilograms = 0.453592;
		 final double inchesToMeters = 0.0254;
		 
		 System.out.println("Please enter your weight, in pounds: ");
		 double weight = scan.nextDouble();
		 
		 System.out.println("Please enter your height, in inches: ");
		 double height = scan.nextDouble();
		 
		 double weightInKg = weight * poundsToKilograms;
		 double heightInMeters = height * inchesToMeters;
		 
		 double bmi = weightInKg / (heightInMeters * heightInMeters);
		 
		 //round bmi and output
		 bmi = Math.round(bmi);
		 System.out.print("Your BMI is: ");
		 System.out.println(bmi);
		 
		 scan.close();
	 }
}