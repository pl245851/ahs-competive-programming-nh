import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Park {
	
	static PriorityQueue<Path>[] map;
	static String[] indexes;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int places = scanner.nextInt();
			int limit = scanner.nextInt();
			map = new PriorityQueue[places];
			for(int i = 0; i<places; i++) {
				map[i] = new PriorityQueue();
			}
			indexes = new String[places];
			for(int i = 1; i < places; i++) {
				indexes[i] = scanner.next();
			}
			indexes[0] = "Entrance";
			for(int i = 0; i<places; i++) {
				for(int j = 0; j<places; j++) {
					int value = scanner.nextInt();
					if(value>0) {
						map[i].add(new Path(j,value));
					}
				}
			}
			boolean[] visited = new boolean[places];
			int here = 0;
			System.out.printf("Theme park visit #%d:%n",c+1);
			while(true) {
				System.out.printf("%s%n",indexes[here]);
				visited[here] = true;
				PriorityQueue<Park.Path> thisqueue = map[here];
				if(limit>=(thisqueue.peek()).weight) {
					while(visited[thisqueue.peek().to]&&!thisqueue.isEmpty()) {
						thisqueue.remove();
					}
					limit-=thisqueue.peek().weight;
					here = thisqueue.remove().to;
				}
				else {
					break;
				}
			}
			System.out.printf("Home%n");
			
		}
	}
	
	public static class Path implements Comparable<Path>{
		int to;
		int weight;
		public Path(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		public int compareTo(Path o) {
			if(this.weight!=o.weight) {
				return this.weight - o.weight;
			}
			else {
				return indexes[this.to].compareTo(indexes[o.to]);
			}
		}
	}
}
