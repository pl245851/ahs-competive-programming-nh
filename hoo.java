import java.util.Scanner;

public class hoo {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
			int check = scanner.nextInt();
			int origcheck = check;
			int count = 0;
			line: while(check!=1) {
				count++;
				for(int i = 2; i<check;i++) {
					if(check%i==0) {
						check/=i;
						continue line;
					}
					
				}
					check/=check;
			}
			//if(origcheck == 1) {
			//	count++;
			//}
			if(count<=3) {
				System.out.printf("Pop #%d: %d licks? Your goose is cooked!%n", c+1, count);
			}
			else {
				System.out.printf("Pop #%d: A-one... A-two-HOO... A-%d.%n", c+1, count);
			}
		}

	}

}
/*
5
6
32
1
1000
999

*/