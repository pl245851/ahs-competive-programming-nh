import java.util.Scanner;

public class Fireworks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for (int i = 1; i<cases+1; i++) {
			int works = scanner.nextInt();
			int[] firework = new int[works];
			int lowest = 0;
			int highest = 0;
			for (int j = 0; j<works;j++) {
				firework[j]=scanner.nextInt();
				if (firework[j]<firework[lowest]) {
					lowest = j;
				}
				if (firework[j]>firework[highest]) {
					highest = j;
				}
			}
			System.out.printf("Scenario #%d:\nHighest Firework: %d\nEarliest Firework: %d%n", i, highest + 1, lowest +1);
		}
		

	}

}
