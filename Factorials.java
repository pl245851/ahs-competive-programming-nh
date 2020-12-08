import java.math.BigInteger;
import java.util.Scanner;

public class Factorials {
	static long MOD = (long)1e9+9;

	static long[] factorials;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		factorials = new long[1001];
		factorials[0] = 1;
		for (int i =1; i<factorials.length; i++) {
			factorials[i] = (i * factorials[i-1]) % MOD;
		}
		int n = scanner.nextInt();
		int r = scanner.nextInt();
		long answer = (factorials[n] * ModInverse(factorials[r])) % MOD;
		System.out.println(factorials[n]);
	}
	public void mod(int a, int b, int m) {
		int r = (a+b)%m;
		int r2 = ((a%m) + (b%m))%m;
		int r3 = (a*b)%m;
		int r4 = ((a%m)*(b%m))%m;
	}
	public void modInv(int a, int b, int m) {
		int r5 = (a-b)%m;
		int r6 = ((a%m)-(b%m))%m; // doesn't work
		
		int r7 = ((a%m)-(b%m)+m) %m; // works
		int modA = a%m;
		int modB = b&m;
		//int c = (a-b)%m == (a+c)%m;
		//c = m - b
		
		int r8 = (a / b) %m;
		int r9 = ((a%m)/(b%m))%m;//not possible
		//int r10 = (a/b)%m == (a*c)%m;
		int c = new BigInteger(Integer.toString(b)).modInverse(new BigInteger(Integer.toString(m))).intValue();
		
		int r10 = a*c %m; // a/b %m
	}
	public static long ModInverse(long b) {
		return new BigInteger(Long.toString(b)).modInverse(new BigInteger(Long.toString(MOD))).longValue();
	}
}
