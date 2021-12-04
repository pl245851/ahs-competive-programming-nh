import java.util.Scanner;

public class banana {
	
	static Point[] points;
	static Point[] spots;
	static double best;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c< cases; c++) {
			int num = scanner.nextInt();
			points = new Point[num];
			spots = new Point[num];
			best = Integer.MAX_VALUE;
			int[] indexes = new int[num];
			for(int i = 0 ; i< num; i++) {
				points[i] = new Point(scanner.nextInt(),scanner.nextInt());
				indexes[i] = i;
			}
			for(int i = 0 ; i< num; i++) {
				spots[i] = new Point(scanner.nextInt(),scanner.nextInt());
			}
			
			permute(indexes, 0, new boolean[num]);
			
			System.out.printf("%.10f%n", best);
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
		double sum = 0;
			for(int i = 0 ; i< indexes.length; i++) {
				sum+= points[indexes[i]].dist(spots[i]);
			}
			best = Math.min(best, sum);
	}
	
	public static class Point{
		int x,y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public double dist(Point o) {
			return Math.sqrt((this.x-o.x)*(this.x-o.x)+(this.y-o.y)*(this.y-o.y));
		}
	}

}
