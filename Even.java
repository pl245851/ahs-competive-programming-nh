import java.util.Scanner;

public class Even {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i < cases; i++) {
			long level = scanner.nextLong();
			long needed = nexthighestbit(level)-level;
			System.out.printf("Pokemon %d: %d%n", i+1, needed);
		}
		
	}
	public static long nexthighestbit(long a) {
		long i = 1;
		for (int j = 0; j>=0; j++) {
			 if(i>a) {
				 return i;
			 }
			 else{
				 i = i*2;
			 }
		}
		return 0;
	}

}