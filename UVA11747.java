import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class UVA11747 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nodeCount = scanner.nextInt();
		int edgeCount = scanner.nextInt();
		while(!(nodeCount == 0)&&!(edgeCount==0)) {
			// We don't actually have to build much of a graph,
			//   we just need to track all of the edges.
			List<Edge> edges = new ArrayList<Edge>();
			for (int i = 0; i < edgeCount; i++) {
				int from = scanner.nextInt();
				int to = scanner.nextInt();
				int weight = scanner.nextInt();
				edges.add(new Edge(from, to, weight));
			}
		
			Collections.sort(edges);
			ArrayList<Integer> removedw = new ArrayList<Integer>();
			// Total weight of the tree
			int totalWeight = 0;
		
			// We need some form of data structure to know when we might make a cycle.
			DisjointSet disjointSet = new DisjointSet(nodeCount);
			for (int i = 0; i < edgeCount; i++) {
				Edge edge = edges.get(i);
				
				if(disjointSet.find(edge.to) == disjointSet.find(edge.from)) {
					totalWeight = totalWeight + edge.weight;
					removedw.add(edge.weight);
					// which parent's cycle is this
					//this parent's cycle is new highest weight
				}
				else {
					disjointSet.union(edge.to,edge.from);
				}
				// Check if including this edge will make a cycle.
				// If it will, skip it.
				// If it won't, include it.
			}
			Collections.sort(removedw);
			if(totalWeight == 0) {
				System.out.printf("forest%n");
			}
			else{
				while(!removedw.isEmpty()) {
					System.out.printf("%d",removedw.get(0));
					removedw.remove(0);
					if(!removedw.isEmpty()) {
						System.out.printf(" ");
					}
					if(removedw.isEmpty()) {
						System.out.printf("%n");
					}
				}
			}
			nodeCount = scanner.nextInt();
			edgeCount = scanner.nextInt();
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
3 3
0 1 1
1 2 2
2 0 3
4 5
0 1 1
1 2 4
2 3 3
3 1 2
0 2 0
3 1
0 1 1
0 0
*/