import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Gossip {
	
	static ArrayList<Integer>[] map;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c< cases; c++) {
			int nodes = scanner.nextInt();
			int connections = scanner.nextInt();
			map = new ArrayList[nodes];
			for(int i = 0; i<nodes; i++) {
				map[i]= new ArrayList<Integer>();
			}
			for(int i = 0; i< connections; i++) {
				int from = scanner.nextInt()-1;
				int to = scanner.nextInt()-1;
				map[from].add(to);
			}
			
			LinkedList<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[nodes];
			queue.add(0);
			while(!queue.isEmpty()) {
				int here = queue.poll();
				if(visited[here]) {
					continue;
				}
				visited[here]=true;
				
				for(int i = 0; i < map[here].size();i++) {
					queue.add(map[here].get(i));
				}
			}
			boolean poss = true;
			for(int i = 0; i< nodes; i++) {
				if(!visited[i]) {
					poss = false;
					break;
				}
			}
			if(poss) {
				System.out.printf("Ookie, oo ah ah!%n");
			}
			else {
				System.out.printf("Oo oo ah ah ookie ah!%n");
			}
			
		}
	}
	
}
