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
		System.out.println(go(cpus,0));

	}

	static int go(int cpuleft, int merchantplace) {
		if(cpuleft == 0) {
			return 0;
		}
		if(merchantplace > prices.length) {
			return 0;
		}
		
		if(memo[cpuleft] != -1) {
			return memo[cpuleft];
		}
		
		for(int i = 0; i< )
		
		
	}

}
