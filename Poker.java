import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poker {

	public static void main(String[] args) {
		List<String> hands = new ArrayList<String>();
		hands.add("Straight flush");
		hands.add("Four of a kind");
		hands.add("Full house");
		hands.add("Flush");
		hands.add("Straight");
		hands.add("Three of a kind");
		hands.add("Two pair");
		hands.add("Pair");
		hands.add("High card");
	
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		scanner.nextLine();
		for(int i=1;i<cases+1;i++) {
			String r = scanner.nextLine();
			String t = scanner.nextLine();
			if (hands.indexOf(r) < hands.indexOf(t)) {
				System.out.printf("Game #%d: Ryan%n", i);
			}
			else {
				System.out.printf("Game #%d: Tyler%n", i);
			}
		}

	}

}
