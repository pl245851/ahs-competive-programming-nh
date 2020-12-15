import java.util.Scanner;

public class jenny {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int length = scanner.nextInt();
			int place = scanner.nextInt();
			
		}
	}
	void sieve(int N)
	{
	    boolean[] isPrime= new boolean[N + 1];
	    for (int i = 0; i& lt; = N; ++i) {
	        isPrime[i] = true;
	    }
	  
	    isPrime[0] = false;
	    isPrime[1] = false;
	  
	    for (int i = 2; i * i <= N; ++i) {
	  
	        // Mark all the multiples of i as composite numbers
	        if (isPrime[i] == true) {
	            for (int j = i * i; j <= N; j += i)
	                isPrime[j] = false;
	        }
	    }
	}

}
