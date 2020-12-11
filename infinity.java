import java.util.Scanner;

public class infinity {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int i = 0; i<cases; i++) {
			String word = scanner.next();
			String s1 = word.substring(0,(int) ((word.length()-word.length()/2)));
			String s2 = word.substring((int) word.length()-word.length()/2, word.length());
			System.out.printf(s1+"-"+s2+"%n");
		}
	}
}