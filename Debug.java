import java.io.IOException;
import java.util.Scanner;

public class Debug {
	/*
	 * Populate the comments with the appropriate code.
	 * 
	 * Take note of the output printing and how the different
	 * types of data can be printed through `printf()`.
	 */
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		
		int wordCount = 0;
		while(scanner.hasNext()) {
			if (wordCount % 4 == 0) {
				int number = scanner.nextInt();
				System.out.printf("Integer: %d%n", number);
			} else if (wordCount % 4 == 1) {
				double decimal = scanner.nextDouble();
				System.out.println("Double: " + decimal);
			} else if (wordCount % 4 == 2) {
				String word = scanner.next();
				System.out.printf("String: %s%n", word);
			} else {
				long bigNumber = scanner.nextLong();
				System.out.printf("Long: %d%n", bigNumber);
				
			}
			wordCount++;
		}
	}
}