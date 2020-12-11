import java.util.Scanner;

public class zero {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int song = 0;
		while (scanner.hasNext()) {
			int votes = scanner.nextInt();
			if (votes != 0) {
				song++;
				int plus = 0;
				int minus = 0;
					String vote = scanner.next();
					for(int j = 0; j<votes; j++) {
						if (vote.charAt(j) == '+') {
							plus++;
						}
						else {
							minus++;
						}
					}
				if(plus>minus) {
					System.out.printf("Song %d: Shreddin%n",song);
				}
				else {
					System.out.printf("Song %d: Guitar Zero%n",song);
				}
			}
		}

	}

}
