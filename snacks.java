import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class snacks {
	
	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int parks = scanner.nextInt();
		for (int p = 0; p < parks; p++) {
			int locations = scanner.nextInt();
			int trails = scanner.nextInt();
			
			map = new ArrayList[locations];
			for (int i = 0; i < locations; i++) {
				// Start each location off assuming no trails connect it.
				map[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < trails; i++) {
				// Locations are 1-based, so subtract 1 to reach 0-based.
				int u = scanner.nextInt() - 1;
				int v = scanner.nextInt() - 1;
				
				// Trails are bidirectional
				map[u].add(v);
				map[v].add(u);
			}
			
			// Make your choice!
			/*
			if (dfs(0)) {
				System.out.println("Time to book!");
			} else {
				System.out.println("Maybe another park?");
			}
			*/
			
			
			if (bfs(locations)) {
				System.out.println("Time to book!");
			} else {
				System.out.println("Maybe another park?");
			}
			
		}
	}
	
	// Determine if its possible to assign a snack type
	// to this location... how do we know which snack to assign this one?
	static boolean dfs(int index) {
		// Have we been here before?
		// If so, are we the proper snack?
		// What about each of the neighboring locations?
		
		return true;
	}
	
	static boolean bfs(int length) { 
		LinkedList<Integer> queue = new LinkedList<>();
		int snack[] = new int[length];
		boolean possible = true;
		LinkedList<Integer> previous = new LinkedList<>();
		queue.addLast(0);
		previous.addLast(1);
		while(!queue.isEmpty()) {
			int place = queue.removeFirst();
			int prev = previous.removeFirst();
		// Have we been here before?
			if(!(snack[place]==0)) {
				// If so, are we the proper flavor?
				if(snack[place]==prev) {
					possible = false;
					break;
				}
			}
			// What about each of the neighboring locations?
			else {
				snack[place] = 3 - prev;
				prev = 3 - prev;
				for(int i = 0; i < map[place].size();i++) {
					queue.add(map[place].get(i));
					previous.add(prev);
				}
			}
		
		
		}
		// If we get here, then we did not find a contradiction, so it was possible!
		if(possible) {
			return true;
		}
		else {
			return false;
		}
		
	}
}