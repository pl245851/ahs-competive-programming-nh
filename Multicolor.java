import java.util.Scanner;

public class Multicolor {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int grids = scanner.nextInt();
		for(int i = 0 ; i<grids;i++) {
			int times = scanner.nextInt();
			int answer = scanner.nextInt();
			for(int j = 0; j< times ; j++) {
				scanner.next();
			}
			System.out.printf("%d%n",answer);
		}
	}
}
