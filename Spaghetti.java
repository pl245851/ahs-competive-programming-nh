import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Spaghetti {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int mice = scanner.nextInt();
		while(mice != 0) {
			ArrayList<Integer>[] map = new ArrayList[mice];
			for(int i = 0; i<mice; i++) {
				map[i]= new ArrayList<Integer>();
			}
			for(int i = 0; i<mice; i++) {
				int possible = scanner.nextInt();
				for(int j = 0; j<possible; j++) {
					map[i].add(scanner.nextInt()-1);
				}
			}
			
			LinkedList<Integer> queue = new LinkedList<>();
			boolean visited[]= new boolean[mice];
			queue.addLast(0);
			boolean possible = false;
			while(!queue.isEmpty()) {
				int mouse = queue.removeFirst();
				if(mouse == mice) {
					possible = true;
					break;
				}
				if(visited[mouse]) {
					continue;
				}
				visited[mouse] = true;
				
			    for(int i = 0; i < map[mouse].size();i++) {
					queue.add(map[mouse].get(i));
				}
		    }
			if(possible) {
				System.out.printf("Thank you so much, wonderful mice!%n");
			}
			else {
				System.out.printf("I wonder if there are any hedgehogs around...%n");
			}
			mice = scanner.nextInt();

	     }

}
}
