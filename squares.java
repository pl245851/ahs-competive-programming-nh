import java.util.Scanner;

public class squares {
	static int[] nums;
	static int total;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			total = 0;
			nums = new int[9];
			for(int i = 0; i<9; i++) {
				nums[i] = scanner.nextInt();
			}
			permute(new int[9], 0, new boolean[9]);
			System.out.printf("%d%n", total);
		}
	}
	public static void permute(int[] indexes, int index, boolean[] used) {
		// See if we are done generating a permutation
		if (index >= indexes.length) {
			// Use the generated indexes for something.
			validate(indexes);
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
	
	public static void validate(int[] indexes) {
		int toprow = nums[indexes[0]]+nums[indexes[1]]+nums[indexes[2]];
		int midrow = nums[indexes[3]]+nums[indexes[4]]+nums[indexes[5]];
		int botrow = nums[indexes[6]]+nums[indexes[7]]+nums[indexes[8]];
		int lefrow = nums[indexes[0]]+nums[indexes[3]]+nums[indexes[6]];
		int midrow2 = nums[indexes[1]]+nums[indexes[4]]+nums[indexes[7]];
		int rigrow = nums[indexes[2]]+nums[indexes[5]]+nums[indexes[8]];
		if(toprow == midrow && midrow==botrow && botrow==lefrow && lefrow==midrow && midrow2==rigrow) {
			total++;
		}
		}
	}
