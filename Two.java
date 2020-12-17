import java.util.Scanner;

public class Two {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0 ; c < cases; c++) {
			StringBuilder sb = new StringBuilder();
			char lastchar = '0';
			String word = scanner.next();
			char[] wordarr = word.toCharArray();
			for(int i = 0; i< wordarr.length; i++) {
				if(wordarr[i]!=lastchar) {
					sb.append(wordarr[i]);
				}
				lastchar = wordarr[i];
			}
			System.out.printf("%s%n", sb);
			
		}
	}
}
