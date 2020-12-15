import java.io.IOException;
import java.util.Scanner;

public class JuiceDratics {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();
		double c = scanner.nextDouble();
		
		findSolutions(a, b, c);
	}
	
	public static void findSolutions(double a, double b, double c) {
		/*
		 * Solve the quadratic equation here.
		 * Set the variables to their appropriate values,
		 * and beware the print statements may not always be necessary!
		 */
		if(Math.pow(b, 2)+(-4*a*c)>=0) {
			double smallerSolution = (-b-Math.sqrt(Math.pow(b, 2)+(-4*a*c)))/(2*a);	
			double largerSolution = (-b+Math.sqrt(Math.pow(b, 2)+(-4*a*c)))/(2*a);
			
			if(smallerSolution < largerSolution) {
				System.out.printf("%.4f%n", smallerSolution);
				if(Math.abs(largerSolution - smallerSolution) >= 0.001) {
					System.out.printf("%.4f%n", largerSolution);
				}
			}
			else {
				System.out.printf("%.4f%n", largerSolution);
				if(Math.abs(largerSolution - smallerSolution) >= 0.001) {
					System.out.printf("%.4f%n", smallerSolution);
				}
			}
				
			
		}
		else{
			System.out.printf("It's a trap!%n");
		}

	}
}