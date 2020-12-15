import java.io.IOException;
import java.util.Scanner;

public class Slopes {
	
	public static double getSlope(double x1, double y1, double x2, double y2) {
		/*
		 * Populate this method according to the problem specifications.
		 * Take note of how printf() below uses
		 * %.3f to round to three decimal places.
		 */
		return ((1.0 * y1-y2)/(x1-x2));
	}
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
				
		for (int c = 0; c < cases; c++) {
			int x1 = scanner.nextInt();
			int y1 = scanner.nextInt();
			int x2 = scanner.nextInt();
			int y2 = scanner.nextInt();
			
			double slope = getSlope(x1, y1, x2, y2);
			
			System.out.printf("%.3f%n", slope);
		}
	}
}
