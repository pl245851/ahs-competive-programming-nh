import java.util.ArrayList;
import java.util.Scanner;

public class emoji {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int i = 0; i < count; i++) {
			String name = scanner.next();
			ArrayList<Character> used = new ArrayList<>();
			boolean done = false;
			for(int j = 0; j< name.length(); j++) {
				if(used.contains(name.charAt(j))) {
					done = true;
					break;
				}
				used.add(name.charAt(j));
			}
			if(!done) {
				System.out.println("Emote away!");
			}
			else {
				System.out.println("Nope");
			}
		}

	}

}
