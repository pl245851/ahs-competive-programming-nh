import java.util.Scanner;

public class mirror {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases;i++) {
			StringBuilder sb = new StringBuilder(scanner.next());
			System.out.printf("%s%n", sb.reverse());
		}

	}

}
