import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class family {
	
	static ArrayList<ArrayList<Integer>> adjacencyList;
	static int target;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int connections = scanner.nextInt();
		int familynum = 0;
		while (connections != 0) {
			adjacencyList = new ArrayList<ArrayList<Integer>>();
			TreeMap<String, Integer> indexes = new TreeMap<>();
			familynum++;
			
			
			for (int i = 0; i < connections; i++) {
				String parent1 = scanner.next();
				String parent2 = scanner.next();
				String child = scanner.next();
				
				if (!indexes.containsKey(parent1)) {
					indexes.put(parent1, indexes.size());
					adjacencyList.add(new ArrayList<>());
				}
				if (!indexes.containsKey(parent2)) {
					indexes.put(parent2, indexes.size());
					adjacencyList.add(new ArrayList<>());
				}
				if (!indexes.containsKey(child)) {
					indexes.put(child, indexes.size());
					adjacencyList.add(new ArrayList<>());
				}
				
				int parent1Index = indexes.get(parent1);
				int parent2Index = indexes.get(parent2);
				int childIndex = indexes.get(child);
				
				adjacencyList.get(parent1Index).add(parent2Index);
				adjacencyList.get(parent1Index).add(childIndex);
				adjacencyList.get(parent2Index).add(parent1Index);
				adjacencyList.get(parent2Index).add(childIndex);
				adjacencyList.get(childIndex).add(parent1Index);
				adjacencyList.get(childIndex).add(parent2Index);
			}
			
			boolean visited[] = new boolean[indexes.size()];
			String person1 = scanner.next();
			String person2 = scanner.next();
			
			int person1Index = indexes.get(person1);
			int person2Index = indexes.get(person2);
			
			target = person2Index;
			
			if (dfs(person1Index, visited)) {
				System.out.printf("Family #%d: Related.%n", familynum);
			} else {
				System.out.printf("Family #%d: Not Related.%n", familynum);
			}
			
			connections = scanner.nextInt();
		}
		
		
	}
	public static boolean dfs(int index, boolean[] visited) {
		visited[index] = true;
		if (index == target) {
			return true;
		}
		for(int i = 0; i<adjacencyList.get(index).size(); i++) {
			if (!visited[adjacencyList.get(index).get(i)]) {
				return dfs(adjacencyList.get(index).get(i), visited);
			}
		}
		return false;
		
	}
}