import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class elemental {

	static List<String>parts;
	static String target;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int leng = scanner.nextInt();
		while(leng!=0) {
			parts = new ArrayList<>();
			for(int i = 0; i< leng; i++) {
				parts.add(scanner.next());
			}
			target = scanner.next();
			
			
			
			
			
			
			
			
			leng = scanner.nextInt();
		}

	}

}
