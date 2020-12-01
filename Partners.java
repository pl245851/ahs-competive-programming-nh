import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class Partners {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int connections = scanner.nextInt();
		int requests = scanner.nextInt();
		int year = 0;
		while(!(connections == 0 && requests == 0)) {
			TreeMap<String, Integer> indexes = new TreeMap<>();
			List<Edge> edges = new ArrayList<Edge>();
			for (int i = 0; i < connections; i++) {
				String from = scanner.next();
				String to = scanner.next();
				
				if(!indexes.containsKey(from)) {
					indexes.put(from, indexes.size());
				}
				if(!indexes.containsKey(to)) {
					indexes.put(to, indexes.size());
				}
				edges.add(new Edge(indexes.get(to),indexes.get(from)));
			}
			DisjointSet disjointSet = new DisjointSet(indexes.size());
			for(Edge edge : edges) {
				if(!(disjointSet.find(edge.to) == disjointSet.find(edge.from))) {
					disjointSet.union(edge.to, edge.from);
				}
			}
			
			System.out.printf("Year %d:%n",year+2020);
			for (int i = 0; i < requests; i++) {
				String request = scanner.next();
				
				if(indexes.containsKey("AHS")&&(disjointSet.find(indexes.get(request)) == disjointSet.find(indexes.get("AHS")))) {
					System.out.printf("%s is already a partner!%n", request);
				}
				else {
					System.out.printf("%s is a good investment!%n", request);
				}
			}
			System.out.println();
			year++;
			connections = scanner.nextInt();
			requests = scanner.nextInt();
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
				rank[a]++;
			} else {
				parents[find(a)] = b;
				if(rank[a]==rank[b]) {
					rank[b]++;
				}
			}
		}
	}
	
	public static class Edge{
		int to;
		int from;
		public Edge(int to, int from) {
			this.to = to;
			this.from = from;
		}
	}
	

}


/*
4 2
AHS DunkinDonuts
AHS Starbucks
Walmart Publix
MasterCard Visa
Starbucks
Publix
5 2
FoxStudios AHS
FoxStudios ESPN
FoxStudios ABC
ESPN FoxSportsFlorida
FoxSportsFlorida FoxStudios
FoxSportsFlorida
FoxStudios
5 2
FoxStudios KoolAid
FoxStudios ESPN
FoxStudios ABC
ESPN FoxSportsFlorida
MinuteMaid KoolAid
FoxSportsFlorida
KoolAid
0 0

*/