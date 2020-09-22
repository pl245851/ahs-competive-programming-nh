import java.util.Scanner;
import java.util.TreeMap;

public class Besties {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int classes = scanner.nextInt();
		for (int c = 0; c < classes; c++) {
			int pairs = scanner.nextInt();
			int queries = scanner.nextInt();
			
			TreeMap<String, String> bff = new TreeMap<>();
			for (int pair = 0; pair < pairs; pair++) {
				String friend1 = scanner.next();
				String friend2 = scanner.next();
				
				bff.put(friend1,friend2);
			}
			
			for (int q = 0; q < queries; q++) {
				String student1 = scanner.next();
				String student2 = scanner.next();
				
				boolean besties = false;
				
				if(bff.containsKey(student1)) {
					besties = bff.get(student1).equals(student2);
							
				}
				else if(bff.containsKey(student2)){
					besties = bff.get(student2).equals(student1);
				}
				
				System.out.printf("%s and %s are%s besties!%n", student1, student2, besties ? "" : " not");
			}
			
			System.out.println();
		}
	}
}