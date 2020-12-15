import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeMap;

public class tournament {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int players = scanner.nextInt();
		int matches = scanner.nextInt();
		int tournament = 1;
		while(!(players == 0 && matches == 0)) {
			LinkedList<Integer> result = new LinkedList<Integer>();
			TreeMap<String, Integer> indexes = new TreeMap<>();
			boolean[] used = new boolean[players];
			int[] incoming = new int[players];
			String[] playerlist = new String[players];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			ArrayList<Integer>[] map = new ArrayList[players];
			for (int i = 0; i < players; i++) {
				map[i] = new ArrayList<Integer>();
				String player = scanner.next();
				indexes.put(player, indexes.size());
				playerlist[i] = player;
			}
			for(int i =0; i<matches; i++) {
				String from = scanner.next();
				String to = scanner.next();
				map[indexes.get(from)].add(indexes.get(to));
				incoming[indexes.get(to)]++;
			}
			for (int i = 0; i< players; i++) {
				if (incoming[i] ==0) {
					queue.add(i);
				}
			}
			
			while(!queue.isEmpty()) {
				int index = queue.removeFirst();
				result.add(index+1);
				
				for (int edge : map[index]) {
					incoming[edge]--;
					if(incoming[edge]==0) {
						queue.add(edge);
					}
				}
			}
			System.out.printf("Tournament %d:%n",tournament);
			if(result.size()==players) {
				int i = 0;
				while(!result.isEmpty()) {
					i++;
					System.out.printf("%d. %s%n" ,i,playerlist[result.removeFirst()-1]);
				}
			}
			else {
				System.out.println("Data is inconsistent, let's eat cake!");
			}
			players = scanner.nextInt();
			matches = scanner.nextInt();
			tournament++;
			System.out.println();
		}

	}

}
