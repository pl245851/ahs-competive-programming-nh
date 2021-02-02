import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class UVA11369 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c< cases; c++) {
			int stuff = scanner.nextInt();
			int ans = 0;
			List<Integer> stuffs = new ArrayList<>();
			for(int i = 0; i<stuff; i++) {
				stuffs.add(scanner.nextInt());
			}
			Collections.sort(stuffs);
			Collections.reverse(stuffs);
			if(stuffs.size() > 2) {
				for(int i = 2; i<stuffs.size(); i+=3) {
					ans+=stuffs.get(i);
				}
			}
			System.out.printf("%d%n", ans);
		}
	}
}
