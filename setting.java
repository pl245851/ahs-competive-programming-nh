import java.util.Scanner;

public class setting {
	
	static long[][] memo;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	

	}
	
	static long go(int difficulty, int problems) {
		if(problems == 0) {
			return 1;
		}
		
		if(difficulty >= memo.length) {
			return 0;
		}
		
		if(memo[difficulty][problems] != -1) {
			return memo[difficulty][problems];
		}
		
		//Take it
		//Don't take it
		
		memo[difficulty][problems] = sum of those two %MOD;
		return memo[difficulty][problems];
				
	}
	
}
