import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class XO {

	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases; i++) {
			int nodes = scanner.nextInt();
			int doors = scanner.nextInt();
			map = new ArrayList[nodes];
			for(int j = 0; j<nodes; j++) {
				map[j] = new ArrayList<Integer>();
			}
			for(int j = 0; j<doors;j++) {
			    int rooma = scanner.nextInt()-1;
			    int roomb = scanner.nextInt()-1;
			    map[rooma].add(roomb);
			    map[roomb].add(rooma);
			}
			if(bfs(nodes)) {
				System.out.printf("Wow, an actual puzzle!%n");
			}
			else {
				System.out.printf("Oh look, I can just walk around.%n");
			}
			
		}

	}

	static boolean bfs(int i) {
		LinkedList<Integer> queue = new LinkedList<>();
		int symbol[] = new int[i];
		boolean possible = true;
		LinkedList<Integer> previous = new LinkedList<>();
		queue.addLast(0);
		previous.addLast(1);
		while(!queue.isEmpty()) {
			int room = queue.removeFirst();
			int prev = previous.removeFirst();
			if(!(symbol[room]==0)) {
				if(symbol[room]==prev) {
					possible = false;
					break;
				}
			}
			else {
				symbol[room] = 3 - prev;
				prev = 3 - prev;
				for(int k = 0; k < map[room].size();k++) {
					queue.addLast(map[room].get(k));
					previous.add(prev);
				}
			}
		}
		
		if(possible) {
			return true;
		}
		else {
		    return false;
		}

	}

}
