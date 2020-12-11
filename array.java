import java.util.Scanner;

public class array {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			int files = scanner.nextInt();
			if (files != 0) {
				String keyword = scanner.next();
				for(int j = 0; j<files;j++) {
					String name = scanner.next();
					String key = scanner.next();
					if(key.equals(keyword)) {
						System.out.printf(name);
						System.out.printf("%n");
				
		}
		
			}
				
			}
		System.out.printf("%n");	
		}
	}

}

