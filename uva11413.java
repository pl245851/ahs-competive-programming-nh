import java.util.Arrays;
import java.util.Scanner;

public class uva11413 {
	
	static int buckets;
	static int vessels;
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
			buckets = scanner.nextInt();
			vessels = scanner.nextInt();
			int[] bucks = new int[buckets];
			for(int i = 0; i< buckets;i++) {
				bucks[i]=scanner.nextInt();
			}
			System.out.printf("%d%n",binarySearch(0, Integer.MAX_VALUE, bucks));
		}
	}
	
	
	
	public static long binarySearch(long lowNumber, long highNumber, int[] bucks){
		int midNumber = (int)((lowNumber + highNumber)/2);
		
		if (lowNumber == midNumber || midNumber == highNumber) {
			return lowNumber;
		}
		
		if (possible(midNumber, bucks)) {
			return binarySearch(lowNumber, midNumber, bucks);
		} else {
			return binarySearch(midNumber, highNumber, bucks);
		}
	}
	
	public static boolean possible(int number,int[] bucks) {
		int[] fill = new int[vessels];
		Arrays.fill(fill ,number);
		boolean poss = true;
		int pos = 0;
		for(int i = 0; i<buckets; i++) {
			boolean notused = true;
			for(int j = pos; j<vessels; j++) {
				
				if(bucks[i]>=fill[j]&&notused) {
					pos++;
				}
				
				if(bucks[i]<fill[j]&&notused) {
					fill[j] -= bucks[i];
					notused = false;
					continue;
				}
			}
			if(notused) {
				poss = false;
				break;
			}
		}
		return poss;
	}
}