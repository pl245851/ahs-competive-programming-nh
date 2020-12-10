import java.util.Scanner;

public class neutrino {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
			double slope = scanner.nextDouble();
			double b = scanner.nextDouble();
			
			System.out.printf("%.4f%n",magnitude(slope,b,tertsearch(slope,b)));
			
		}
	}
	public static double tertsearch(double slope, double b){
		double max = 501;
		double min = -501;
		double epsilon = 0.000001;
		while(true) {
			double diff = max - min;
			double lprime = (min+diff/3);
			double rprime = (max-diff/3);
			if(Math.abs(rprime-lprime)<epsilon) {
				return rprime;
			}
			
			if(magnitude(slope, b, lprime)<=magnitude(slope, b, rprime)) {
				max = rprime;
			}
			else {
				min = lprime;
			}
		}
	}
	
	public static double magnitude(double slope, double b, double x) {
		double square = (x*slope+b)*(x*slope+b)+x*x;
		return Math.sqrt(square);
	}
}
