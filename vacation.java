import java.util.Scanner;

public class vacation {
	static point[] rides;
	static double best;
    static boolean[][] blockade;
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			best = Double.MAX_VALUE;
			int ridesnum = scanner.nextInt();
			int blockades = scanner.nextInt();
			int[] indexes = new int[ridesnum];
			rides = new point[ridesnum];
			blockade = new boolean[ridesnum][ridesnum];
			boolean[] tempused = new boolean[ridesnum];
			for(int i = 0; i< ridesnum; i++) {
				rides[i] = new point(scanner.nextInt(),scanner.nextInt());
				indexes[i] = i;
				tempused[i] = false;
			}
			for(int i = 0; i< blockades; i++) {
				int to = scanner.nextInt()-1;
				int from = scanner.nextInt()-1;
				blockade[to][from] = true;
				blockade[from][to] = true;
			}
			permute(indexes, 0, tempused);
			System.out.printf("Vacation #%d:%n",c+1);
			if(best!=Double.MAX_VALUE) {
				System.out.printf("Jimmy can finish all of the rides in %.3f seconds.%n%n", best);
			}
			else {
				System.out.printf("Jimmy should plan this vacation a different day.%n%n");
			}
		}

	}
	// This method will recursively generate all permutations
		// of numbers from 0 to indexes.length - 1
		//
		// indexes = the 0-based indexes
		// index = current location of indexes we are to place data in next
		// used = which indexes we've already put into the array
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
		
		// This method takes a permutation of an array from 0...n
		// This could be used to traverse a graph, or produce an
		// ordering of n other numbers, etc.
		public static void validate(int[] indexes) {
			// For example, perhaps we have an array of numbers
			
			// We may want to check which ordering produces the greatest
			// sum of differences. For example, the current ordering
			// gives us |1-4| + |4-6| + |6-10| + |10 -15| = 14
			
			double sum = 120+Math.hypot(rides[indexes[0]].x, rides[indexes[0]].y);
			for (int i = 1; i < rides.length; i++) {
				// Instead of using i as our index, just reference
				// indexes[i] instead
				int prevIndex = indexes[i - 1];
				int thisIndex = indexes[i];
				if(blockade[prevIndex][thisIndex]) {
					return;
				}
				sum += Math.hypot((rides[prevIndex].x - rides[thisIndex].x),(rides[prevIndex].y - rides[thisIndex].y))+120;
			}
			
			if(sum<best) {
				best = sum;
			}
		}

		public static class point{
			int x;
			int y;
			
			public point(int y, int x){
				this.x = x;
				this.y = y;
			}
		}
}

/*
4
4 0
0 2
2 2
2 4
4 4

5 4
10 10
12 35
64 60
3 7
100 857
1 2
1 3
1 4
1 5

5 2
0 5
0 10
0 20
0 50
0 25
3 4
1 2

1 0
1 0

 */




