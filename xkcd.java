import java.util.Arrays;
import java.util.Scanner;

public class xkcd {

	static int length;
	static char[] alpha = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		length = scanner.nextInt();
		boolean[] usetemp =new boolean[20];
		int[] index = new int[20];
		for(int i = 0; i<20;i++) {
			usetemp[i] = false;
			index[i] = i;
		}
		while(length != 42) {
			if(length >7 || length<2) {
				System.out.printf("XKCD-like name(s) of length: %d%nMostly Harmless%n",length);
			}
			else {
				System.out.printf("XKCD-like name(s) of length: %d%n", length);
				
				permute(index,0,usetemp);
				
			}
			length = scanner.nextInt();
		}
		System.out.printf("The answer to life, the universe and everything!%n");
	}
	
	
	public static void permute(int[] indexes, int index, boolean[] used) {
		// See if we are done generating a permutation
		if (index >= indexes.length || index==length) {
			// Use the generated indexes for something.
			validate(Arrays.copyOfRange(indexes,0,length));
			return;
		}
		
		// Place all possibilities of unused indexes into the array
		for (int i = 0; i < indexes.length; i++) {
			// Check if we haven't included this index yet
			if (!used[i]) {
				// Generate a permutation with i in this index
				used[i] = true;
				indexes[index] = i;
				
				permute(indexes, index + 1, used);
				
				
				// Remove i from used to allow it to be used in
				// future permutations.
				used[i] = false;
			}
		}
	}
	
	
	// This method takes a permutation of an array from 0...n
	// This could be used to traverse a graph, or produce an
	// ordering of n other numbers, etc.
	public static void validate(int[] indexes) {
		// For example, perhaps we have an array of numbers
		
		// We may want to check which ordering produces the greatest
		// sum of differences. For example, the current ordering
		// gives us |1-4| + |4-6| + |6-10| + |10 -15| = 14
		
		StringBuilder sb = new StringBuilder();
		
		int sum = 0;
		for (int i = length-1; i >= 0; i--) {
			sum += alpha[indexes[i]]-96;
			if(i == 1) {
				sb.append(alpha[indexes[0]]);
			}
			else if(i==0) {
				sb.append(alpha[indexes[1]]);
			}
			else {
				sb.append(alpha[indexes[i]]);
			}
			
		}
		
		if(sum == 42) {
			System.out.printf("%s%n", sb);
		}
	}
}
