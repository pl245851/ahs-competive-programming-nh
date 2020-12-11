import java.util.Scanner;

public class taekwondo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int belts = scanner.nextInt();
		for(int i = 0; i<belts;i++) {
			int count = 0;
			int belt = scanner.nextInt();
			for(int j = 1; j<=belt; j++) {
				count = count + j;
			}
			System.out.printf(String.valueOf(count)+"%n");
		}

	}

}
