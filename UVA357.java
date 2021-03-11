import java.util.Scanner;
// is knapsack
public class UVA357 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] coins = {1, 5, 10, 25, 50};//weights
		long[] memo = new long[30001];
		memo[0] =1;
		for(int i = 0; i < coins.length; i++) { //(int i = coins.length-1; i>=0; i--){ allows you to only use each coin once
			for(int index = 0; index < memo.length; index++) {
				int previous = index - coins[i];
				if(previous <0) continue;
				
				memo[index] += memo[previous];
			}
		}
		while(scanner.hasNext()) {
			int num = scanner.nextInt();
			System.out.printf("%d%n", memo[num]);
		}
	}
}
