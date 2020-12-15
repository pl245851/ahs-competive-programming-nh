import java.util.Scanner;

public class Hashmat{
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
				
		while (scanner.hasNext()) {
			long hashmat = scanner.nextLong();
			long enemy = scanner.nextLong();
			
			
			System.out.println(Math.abs(hashmat - enemy));
		}
	}
}