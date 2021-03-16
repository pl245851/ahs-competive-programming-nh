import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class J {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			TreeMap<String, Integer> dict = new TreeMap<>();
			
			String start = scanner.next();
			String end = scanner.next();
			dict.put(start, 0);
			dict.put(end, 1);
			int words = scanner.nextInt();
			ArrayList<Integer>[] edges = new ArrayList[words+2];
			for(int i = 0; i< words+2; i++) {
				edges[i] = new ArrayList();
			}
			for(int i = 0; i< words; i++) {
				char[] word = scanner.next().toCharArray();
				dict.put(new String(word), i+2);
				Set<String> keys = dict.keySet();
				for(String wordss : keys){
					if(! wordss.equals(new String(word))) {
					for(int j = 0; j<wordss.length(); j++) {;
						char[] word2 = word;
						char[] wordss2 = wordss.toCharArray();
						word2[j] = wordss2[j];
						if(new String(word2).equals(new String(wordss2))) {
							edges[i+2].add(dict.get(wordss));
							edges[dict.get(wordss)].add(i+2);
						}
					}
					}
				}
				
			}
			LinkedList<Integer> queue = new LinkedList<>();
			queue.add(0);
			queue.add(0);
			boolean[] visited = new boolean[words+2];
			while(!queue.isEmpty()) {
				int num = queue.poll();
				int dist = queue.poll();
				if(num == 1) {
					System.out.printf("%d%n", dist-1);
				}
				for(int i : edges[num]) {
					if(!visited[i]) {
						visited[i] = true;
						queue.add(i);
						queue.add(dist+1);
					}
				}
			}
				
		}

	}
	
}

