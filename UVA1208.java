import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UVA1208 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
					int nodeCount = scanner.nextInt();
					scanner.nextLine();
					// We don't actually have to build much of a graph,
					//   we just need to track all of the edges.
					List<Edge> edges = new ArrayList<Edge>();
					//////////////////////////////////////////////////////////////////////////////////
					for (int c1 = 0; c1 < nodeCount; c1++) {
						String line = scanner.nextLine();
						StringTokenizer st = new StringTokenizer(line,", ");
						for(int c2 = 0; c2 < c1; c2++) {
							String tok = st.nextToken();
							if(!(Integer.valueOf(tok)==0)){
								edges.add(new Edge(c2, c1, Integer.valueOf(tok)));
							}
						}
					}/////////////////////////////////////////////////////////////////////////////////
					Collections.sort(edges);
					String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					System.out.printf("Case %d:%n", c+1);
					// We need some form of data structure to know when we might make a cycle.
					DisjointSet disjointSet = new DisjointSet(nodeCount);
					for (int i = 0; i < edges.size(); i++) {
						Edge edge = edges.get(i);

						if(disjointSet.find(edge.to) == disjointSet.find(edge.from)) {
							continue;
						}
						else {
							disjointSet.union(edge.to,edge.from);
							System.out.printf("%c-%c %d%n",alpha.charAt(edge.from),alpha.charAt(edge.to),edge.weight);
						}
						// Check if including this edge will make a cycle.
						// If it will, skip it.
						// If it won't, include it.
					}
				}
		}
	
	
	// The DisjointSet keeps track of the "parent" of each node.
	// By default, the parent of each node should be themselves.
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
				rank[a]++;
			} else {
				parents[find(a)] = b;
				rank[b]++;
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
/*
4
6
0, 8, 12, 0, 0, 7
8, 0, 0, 3, 0, 0
12, 0, 0, 0, 6, 0
0, 3, 0, 0, 0, 4
0, 0, 6, 0, 0, 5
7, 0, 0, 4, 5, 0
6
0, 8, 12, 1, 1, 7
8, 0, 1, 3, 1, 1
12, 1, 0, 1, 6, 1
1, 3, 1, 0, 1, 4
1, 1, 6, 1, 0, 5
7, 1, 1, 4, 5, 0
2
0, 0
1, 0
6
0, 0, 0, 0, 0, 1
0, 0, 0, 0, 0, 1
0, 0, 0, 0, 0, 1
0, 0, 0, 0, 0, 1
0, 0, 0, 0, 0, 1
1, 1, 1, 1, 1, 0
*/