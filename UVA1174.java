import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class UVA1174 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int casess = 0; casess< cases; casess++) {
			int nodeCount = scanner.nextInt();
			int edgeCount = scanner.nextInt();
			TreeMap<String, Integer> indexes = new TreeMap<>();
			// We don't actually have to build much of a graph,
			//   we just need to track all of the edges.
			List<Edge> edges = new ArrayList<Edge>();
			for (int i = 0; i < edgeCount; i++) {
				String from = scanner.next();
				String to = scanner.next();
				int weight = scanner.nextInt();
				
				if(!indexes.containsKey(from)) {
					indexes.put(from, indexes.size());
				}
				if(!indexes.containsKey(to)) {
					indexes.put(to, indexes.size());
				}
				edges.add(new Edge(indexes.get(from), indexes.get(to), weight));
			}
		
			Collections.sort(edges);
		
			// Total weight of the tree
			int totalWeight = 0;
		
			// We need some form of data structure to know when we might make a cycle.
			DisjointSet disjointSet = new DisjointSet(nodeCount);
		
			for (int i = 0; i < edgeCount; i++) {
				Edge edge = edges.get(i);
			
				if(disjointSet.find(edge.to) == disjointSet.find(edge.from)) {
					continue;
				}
				else {
					disjointSet.union(edge.to,edge.from);
				totalWeight = totalWeight + edge.weight;
				}
				// Check if including this edge will make a cycle.
				// If it will, skip it.
				// If it won't, include it.
			}
		
			System.out.println(totalWeight);
			if(scanner.hasNext()) {
				System.out.println("");
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
				// Make B's parent A
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
3

4
5
lisbon london 6
lisbon paris 5
london paris 1
london berlin 2
paris berlin 10

4
5
lisbon london 6
lisbon paris 5
london paris 1
london berlin 2
paris berlin 10

4
5
lisbon london 6
lisbon paris 5
london paris 1
london berlin 2
paris berlin 10
*/