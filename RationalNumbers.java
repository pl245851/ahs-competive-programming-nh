import java.util.Scanner;

public class RationalNumbers {
	
	static int targetNumerator;
	static int targetDenominator;
	static double targetFraction;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		targetNumerator = scanner.nextInt();
		targetDenominator = scanner.nextInt();
		targetFraction = 1.0 * targetNumerator / targetDenominator;
		while(targetNumerator !=1 || targetDenominator!=1) {
			System.out.printf("%s%n",binarySearch(1,0,0,1));
			targetNumerator = scanner.nextInt();
			targetDenominator = scanner.nextInt();
			targetFraction = 1.0 * targetNumerator / targetDenominator;
		}
	}
	
	
	
	public static String binarySearch(
			int lowNumerator,
			int lowDenominator,
			int highNumerator,
			int highDenominator
	) {
		int midNumerator = lowNumerator + highNumerator;
		int midDenominator = lowDenominator + highDenominator;
		
		if (targetNumerator == midNumerator &&
			targetDenominator == midDenominator) {
			return "";
		}
		
		double midFraction = 1.0 * midNumerator / midDenominator;
		
		if (targetFraction < midFraction) {
			return "L" + binarySearch(
					midNumerator,
					midDenominator,
					highNumerator,
					highDenominator);
		} else {
			return "R" + binarySearch(
					lowNumerator,
					lowDenominator,
					midNumerator,
					midDenominator);
		}
	}
}