import java.util.Scanner;
import java.util.TreeMap;

public class north {
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		int cases = scanner.nextInt();
		for(int c = 0; c<cases; c++) {
			TreeMap<Character, Float> directions = new TreeMap<>();
			directions.put('E', (float) 90);
			directions.put('N', (float) 360);
			directions.put('S', (float) 180);
			directions.put('W', (float) 270);
			String direction = scanner.next();
			Float total = directions.get(direction.charAt(direction.length()-1));
			for(int i =direction.length()-1; i>=0; i--) {
				if(total<=90) {
					total = ((total + directions.get(direction.charAt(i)))%360)/2;
				}
				else {
					total = (total + directions.get(direction.charAt(i)))/2;
				}
				
			}
			System.out.printf("%s is %.1f degrees%n",direction, total%360);
		}
	}
}
