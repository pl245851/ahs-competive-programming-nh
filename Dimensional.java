import java.util.Scanner;

public class Dimensional {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
			int dimensions = scanner.nextInt();
			int[] pointa = new int[dimensions];
			int[] pointb = new int[dimensions];
			for(int i = 0; i < dimensions; i++) {
				pointa[i] = scanner.nextInt();
			}
			for(int i = 0; i< dimensions; i++) {
				pointb[i] = scanner.nextInt();
			}
			int totalsq = 0;
			for(int i = 0; i< dimensions; i++) {
				totalsq+= Math.pow(Math.abs(pointa[i]-pointb[i]),2);
			}
			System.out.printf("%.3f%n", Math.sqrt(totalsq));
		}
	}
}
