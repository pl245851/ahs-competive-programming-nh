import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class isolatedper {
	
	static ArrayList<Integer>[] map;
	static int best;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c< cases; c++) {
			best = 0;
			int islands = scanner.nextInt();
			int crossings = scanner.nextInt();
			map = new ArrayList[islands];
			for(int i = 0; i< islands; i++) {
				map[i] = new ArrayList<Integer>();
			}
			for (int i = 0; i < crossings; i++) {
				// Locations are 1-based, so subtract 1 to reach 0-based.
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;
				
				// Trails are bidirectional
				map[u].add(v);
				map[v].add(u);
			}
			permute(new boolean[islands],0);
			System.out.printf("%d%n", best);
			
			
		}

	}
	public static void permute(boolean[] indexes, int index) {
		if (validate(indexes)&&index<indexes.length) {
			indexes[index] = true;
			permute(indexes, index + 1);
			indexes[index] = false;
			permute(indexes, index + 1);
		}
	}
	
	public static boolean validate(boolean[] indexes) {
		int total = 0;
		for(int i = 0; i< indexes.length; i++) {
			if(indexes[i]) {
				total++;
			}
			for(int j = 0; j<map[i].size(); j++) {
				if(indexes[map[i].get(j)] && indexes[i]) {
					return false;
				}
			}
		}
		
		best = Math.max(best, total);
		return true;
	}

}


/*
8
5 3
1 2
2 3
1 4

4 0

6 8
1 2
2 3
3 4
4 5
5 6
6 1
1 3
2 4

7 6
1 7
2 7
3 7
4 7
5 7
6 7

7 8
1 2
1 3
2 4
3 4
4 5
4 7
7 6
5 6

2 2
1 2
2 1

3 3
1 2
2 3
3 1

6 8
1 2
2 3
3 4
3 5
4 5
4 6
5 6
3 6
*/
