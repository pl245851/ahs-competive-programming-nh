import java.util.Scanner;

public class Track {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int cases= scanner.nextInt();
		for(int c = 0 ; c<cases; c++) {
			double straight = scanner.nextInt();
			double lengthm =scanner.nextInt();
			double lengthz = scanner.nextInt();
			double lapsm = scanner.nextInt();
			double lapsz = scanner.nextInt();
			double distancez = 2 * (3.141592653589793 * lengthz + straight)* lapsz;
			double distancem = 2 * (3.141592653589793 * lengthm + straight)* lapsm ;
			if(distancez>distancem) {
				System.out.printf("Track #%d: I've run %.0f more meters than Mack!!!%n", c+1, distancez-distancem);
			}
			else{
				System.out.printf("Track #%d: Drats!%n", c+1);
			}
		}
	}
}
