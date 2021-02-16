import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVA11292 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int necks = scanner.nextInt();
		int knights = scanner.nextInt();
		while(necks!=0||knights!=0) {
			ArrayList<Integer> dragons = new ArrayList<>();
			ArrayList<Integer> heights = new ArrayList<>();
			for(int i = 0; i < necks; i++) {
				dragons.add(scanner.nextInt());
			}
			Collections.sort(dragons);
			for(int i = 0; i < knights; i++) {
				heights.add(scanner.nextInt());
			}
			Collections.sort(heights);
			int cost = 0;
			while(!dragons.isEmpty()) {
				if(heights.size()==0) {
					break;
				}
				if(heights.get(0)>=dragons.get(0)) {
					cost+=heights.get(0);
					dragons.remove(0);
					heights.remove(0);
				}
				else {
					heights.remove(0);
				}
			}
			if(dragons.size()!=0) {
				System.out.printf("Loowater is doomed!%n");
			}
			else {
				System.out.printf("%d%n", cost);
			}
			
			
			
			necks = scanner.nextInt();
			knights = scanner.nextInt();
		}

	}

}
