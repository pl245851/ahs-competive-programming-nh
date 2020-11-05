import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class bacon {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int collections = scanner.nextInt();
		for (int collection = 1; collection <= collections; collection++) {
			int numberOfMovies = scanner.nextInt();
			int numberOfQueries = scanner.nextInt();
			
			// This converts an actor's name into an integer
			Map<String, Integer> indeces = new TreeMap<String, Integer>();
			
			// The arraylist at the actor's index (^^^^) represents their adjacency list
			ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			
			for (int m = 0; m < numberOfMovies; m++) {
				int numberOfActors = scanner.nextInt();
				int[] actorsInThisMovie = new int[numberOfActors];
				for (int a = 0; a < numberOfActors; a++) {
					String name = scanner.next();
					int actorIndex = -1;
					// Ensure the indeces map contains this actor.
					// Set the actorIndex equal to the appropriate value.
					// If you needed to add to the map, make sure there is an additional ArrayList in `graph` too!
					
					actorsInThisMovie[a] = actorIndex;
				}
				
				// Now that we have all of the actor's indeces,
				// let's make sure all of the actors have edges between them
				
				// graph.get(actor1Index).add(actor2Index);
			}
			
			// Now that we have a graph where each actor has an edge
			// to each of the other actors they have directly worked
			// with, we just need to find the smallest number of
			// links between a pair of actors.
			
			System.out.printf("Movie collection #%d:%n", collection);
			for (int q = 0; q < numberOfQueries; q++) {
				String actor1 = scanner.next();
				String actor2 = scanner.next();
				
				int actor1Index = indeces.get(actor1);
				int actor2Index = indeces.get(actor2);
				
				int distance = bfs(graph, actor1Index, actor2Index);
				
				// How to know if there was no way to link the two actors?
				boolean ableToReach = true;
				if (ableToReach) {
					System.out.printf("The Bacon Number between %s and %s is %d.%n", actor1, actor2, distance);
				} else {
					System.out.printf("The Bacon Number between %s and %s is infinity!%n", actor1, actor2);
				}
			}
			
			System.out.println();
		}
	}
	
	static int bfs(ArrayList<ArrayList<Integer>> graph, int start, int end) {
		LinkedList<State> queue = new LinkedList<>();
		boolean[] visited = new boolean[graph.size()];
		
		// Initial state is the first actor.
		queue.add(new State(start, 0));
		while (!queue.isEmpty()) {
			// Grab the next state off the queue.
			State state = queue.removeFirst();
			int index = state.index;
			int distance = state.distance;
			
			// Have we reached the goal?
			if (index == end) {
				return state.distance;
			}
			
			// Have we already been here?
			if (visited[index]) {
				continue;
			}
			
			// First time, have a t-shirt!
			visited[index] = true;
			int nextDistance = distance + 1;
			
			// For each of the actors this one has worked with...
			for (int i = 0; i < graph.get(index).size(); i++) {
				// ... add them to the queue with one extra distance.
				queue.addLast(new State(graph.get(index).get(i), nextDistance));
			}
		}
		
		// If we have reached here, we could not link the two actors.
		// What can we return instead?
	}
	
	static class State {
		int index;
		int distance;
		
		public State(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
	}
}