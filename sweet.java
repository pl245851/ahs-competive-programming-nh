import java.util.Scanner;

public class sweet {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int i = 0; i<count; i++) {
			int weeks = scanner.nextInt();
			int tot = 0;
			System.out.printf("Scenario %d:%n",i+1);
			for(int j = 0; j<weeks; j++) {
				tot = tot + scanner.nextInt();
				if(tot>=50) {
					System.out.printf("Sweet!%n");
					tot= tot-50;
				}
				else {
					System.out.printf("Bummer, I need to wait.%n");
				}
			}
			System.out.printf("%n");
		}

	}

}
