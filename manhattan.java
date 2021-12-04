import java.util.Scanner;

public class manhattan {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int c = 0; c< count; c++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			//double manhat = i-x + j-y;
			//double euclid = Math.sqrt((i-x)*(i-x) + (j-y)*(j-y));
			if((i-x)*(j-y)!=0) {
				System.out.println("Euclid is too fast! ");
			}
			else {
				System.out.println("Dr. Manhattan wins again!");
			}
		}

	}

}
