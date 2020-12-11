import java.util.Scanner;

public class splash {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int i = 0; i<count; i++) {
			long a = scanner.nextLong();
			long b = scanner.nextLong();
			System.out.printf("%d%n", a*b);
		}

	}

}
