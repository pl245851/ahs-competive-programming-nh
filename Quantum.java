import java.util.PriorityQueue;
import java.util.Scanner;

public class Quantum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int nodes = scanner.nextInt();
			int edges =scanner.nextInt();
			PriorityQueue<Edge> edgelist = new PriorityQueue<>();
			for(int i = 0; i<edges; i++) {
				edgelist.add(new Edge(scanner.nextInt()-1,scanner.nextInt()-1,scanner.nextInt()));
			}
			int total = 0;
			DisjointSet ds = new DisjointSet(nodes);
			while(!edgelist.isEmpty()) {
				Edge edge = edgelist.poll();
				if(ds.find(edge.to) == ds.find(edge.from)) {
					continue;
				}
				else {
					ds.union(edge.to,edge.from);
					total+=edge.weight;
				}
			}
			System.out.printf("%d%n", total);
		}
	}
	
	public static class DisjointSet {	
		int[] rank;
		int[] parents;
		public DisjointSet(int nodes) {
			rank = new int[nodes];
			parents = new int[nodes];
			for(int i = 0; i<nodes; i++) {
				parents[i] = i;
			}
		}
		
		// `node`: the node to retrieve the parent for.
		// If the parent of the node is itself, then it is just themselves.
		// Otherwise, find the parent of your parent.
		// Make sure to note that parent for later use!
		public int find(int node) {
			if(parents[node] == node) {
				return node;
			}
			else {
				return find(parents[node]);
			}
		}
		
		// Combine the two nodes a and b.
		// Assign a new parent to either a or b.
		//   Choose the parent based on which one has the higher rank.
		//   If a's rank is greater than b's, then a should become b's parent.
		//   Ties can go either way, but whichever you choose needs to have their rank increased ONLY WHEN THE RANKS ARE TIED.
		public void union(int a, int b) {
			if (rank[a] > rank[b]) {
				parents[find(b)] = a;
				// Make B's parent A
			} else {
				parents[find(a)] = b;
				if(rank[a]==rank[b]) {
					rank[b]++;
				}
			}
		}
	}
	
	// What makes one Edge a better choice than another Edge?
	// How can we tell Java this?
	public static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
}
