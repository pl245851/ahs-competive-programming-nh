import java.util.Scanner;

public class cpus {
		
	static int[] memo;
	static int[][] prices;
		
	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		int cpus = scanner.nextInt();
		int merchants = scanner.nextInt();
		memo = new int[cpus];
		prices = new int[merchants][cpus];
		for(int  i = 0 ; i< merchants; i++) {
			for(int j  = 0 ; j< cpus; j++) {
				prices[i][j] = scanner.nextInt();
			}
		}
		System.out.println(go(0,0));

	}

	private static int go(int cpusold, int merchantplace) {
		
	}

}
