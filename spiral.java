import java.util.Scanner;

public class spiral {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			double log = (Math.log10(y)/(Math.log10(x)));
			System.out.printf("%.3f%n",log);
		}

	}

}
