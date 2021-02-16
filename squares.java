import java.util.Scanner;

public class squares {
	static int[] nums;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			nums = new int[9];
			for(int i = 0; i>9; i++) {
				nums[i] = scanner.nextInt();
			}
			
		}
	}
}
