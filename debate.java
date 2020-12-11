import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class debate {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i =0; i<cases; i++) {
			Map<String, Integer> team1 = new TreeMap<>();
			Map<String, Integer> team2 = new TreeMap<>();
			int topics1 = scanner.nextInt();
			int topics2 = scanner.nextInt();
			for(int j = 0; j<topics1; j++) {
				team1.put(scanner.next(),scanner.nextInt());
			}
			for(int j = 0; j<topics2; j++) {
				team2.put(scanner.next(),scanner.nextInt());
			}
			int points1 = 0;
			int points2 = 0;
			int topicsP= scanner.nextInt();
			for(int k = 0; k<topicsP; k++) {
				String T = scanner.next();
				points1 = points1 + team1.get(T);
				points2 = points2 + team2.get(T);
			}
			if(points1>points2) {
				System.out.printf("Team 1 wins!%n");
			}
			else if (points1<points2) {
				System.out.printf("Team 2 wins!%n");
			}
			else {
				System.out.printf("It is a tie!%n");
			}
		}

	}

}
