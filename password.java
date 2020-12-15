import java.util.Scanner;

public class password {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			System.out.printf("%.0f%n",Math.pow(4, scanner.nextInt()) );
		}
	}
}
