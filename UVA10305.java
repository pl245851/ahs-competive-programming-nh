import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class UVA10305 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int sticks = scanner.nextInt();
		int crossings = scanner.nextInt();
		LinkedList<Integer> result = new LinkedList<Integer>();
		while(!(sticks ==0)||!(crossings == 0)) {
			boolean[] used = new boolean[sticks];
			int[] incoming = new int[sticks];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			ArrayList<Integer>[] map = new ArrayList[sticks];
			for (int i = 0; i < sticks; i++) {
				map[i] = new ArrayList<Integer>();
			}
			for(int i =0; i<crossings; i++) {
				int from = scanner.nextInt()-1;
				int to = scanner.nextInt()-1;
				map[from].add(to);
				incoming[to]++;
			}
			
			for (int i = 0; i< sticks; i++) {
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
			
			while(!result.isEmpty()) {
				System.out.printf("%d",result.removeFirst());
				if(!result.isEmpty()) {
					System.out.printf(" ");
				}
			}
			System.out.printf("%n");
			sticks = scanner.nextInt();
			crossings = scanner.nextInt();
		}
		
	}
}
