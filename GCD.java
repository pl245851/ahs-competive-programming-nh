import java.util.Scanner;

public class GCD {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int cases = scanner.nextInt();
		for (int c = 0; c < cases; c++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			int gcd = gcd(a, b);
			
			System.out.println(gcd);
		}
	}
	
	private static int gcd(int a, int b) {
		if(a==b) {
			return a;
		}
		else {
			if(a>b) {
				for(int i = b; i>1; i-- ) {
					if(a%i == 0 && b%i == 0) {
						return i;
					}
				}
			}
			else {
				for(int i = a; i>1; i-- ) {
					if(a%i == 0 && b%i == 0) {
						return i;
			}
		}		
	}
			return 1;
}
	}
}