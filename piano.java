import java.util.Scanner;

public class piano {
	static String KEYS = "ABCDEFG";
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c< cases; c++) {
			String sheet = scanner.next();
			for(int i = 0 ; i< sheet.length(); i++) {
				System.out.print("L");
			}
			System.out.println();
		}

	}

}
